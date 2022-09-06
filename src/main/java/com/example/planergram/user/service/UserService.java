package com.example.planergram.user.service;

import com.example.planergram.user.DTO.UserDTO;
import com.example.planergram.user.DTO.UserInfoDTO;
import com.example.planergram.user.model.User;
import com.example.planergram.user.model.UserInfo;
import com.example.planergram.user.repository.UserInfoRepository;
import com.example.planergram.user.repository.UserRepository;
import com.example.planergram.userLike.model.RentCarLike;
import com.example.planergram.userLike.model.StayLike;
import com.example.planergram.userLike.model.TrainLike;
import com.example.planergram.userLike.repository.RentCarLikeRepository;
import com.example.planergram.userLike.repository.StayLikeRepository;
import com.example.planergram.userLike.repository.TrainLikeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private RentCarLikeRepository rentCarLikeRepository;

    @Autowired
    private StayLikeRepository stayLikeRepository;

    @Autowired
    private TrainLikeRepository trainLikeRepository;

    public String signUp(UserDTO userDTO) throws Exception {
        try {
            userRepository.findByNickname(userDTO.getNickname());
            userRepository.findByLoginId(userDTO.getLoginId());
            userInfoService.checkByEmail(userDTO.getUserInfoDTO().getEmail());
            log.info("중복된 정보가 없습니다.");
        } catch (Exception e){
            throw new Exception("중복된 정보로는 아이디를 만들 수 없습니다.");
        }

        User user = User.builder()
                .password(userDTO.getPassword())
                .nickname(userDTO.getNickname())
                .loginId(userDTO.getLoginId())
                .build();
        user = userRepository.save(user);
        UserInfo userInfo = userInfoService.save(user,userDTO.getUserInfoDTO());
        user.setUserInfo(userInfo);
        userRepository.save(user);
        return "회원가입이 완료되었습니다";
    }

    // 회원조회
    public List<UserDTO> findAll() {
        List<User> userList = userRepository.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();
        for (User user : userList) {
            userDTOList.add(makeUserDTO(user));
        }
        log.info("user Find All");
        return userDTOList;
    }

    //회원 업데이트
    public User update(Long id, UserDTO userDTO) throws Exception {
        User findUser = userRepository.findById(id).orElseThrow(Exception::new);
        findUser.setLoginId(userDTO.getLoginId());
        findUser.setPassword(userDTO.getPassword());
        findUser.setNickname(userDTO.getNickname());
        log.info("userService : update complete");
        return userRepository.save(findUser);
    }

    public UserDTO updateUserAndInfo(Long id, UserDTO userDTO) {
        User foundUser = userRepository.getById(id);
        User user = makeUser(userDTO);
        user.setUserId(foundUser.getUserId());
        user = userRepository.save(user);

        UserInfoDTO userInfoDTO = userInfoService.update(user.getUserId(), userDTO.getUserInfoDTO());
        UserDTO newUserDTO = makeUserDTO(user);
        newUserDTO.setUserInfoDTO(userInfoDTO);
        log.info("userinfo update");
        return newUserDTO;
    }

    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User foundUser = userRepository.getById(id);
        User user = makeUser(userDTO);
        user.setUserId(foundUser.getUserId());
        user = userRepository.save(user);
        log.info("user update");
        return makeUserDTO(user);
    }

    public UserDTO getUserAndInfo(Long id) {
        User user = userRepository.getById(id);
        log.info("user & info get By Id");
        return makeUserAndInfoDTO(user);
    }

    public UserDTO getUser(Long id) {
        User user = userRepository.getById(id);
        log.info("user get By Id");
        return makeUserDTO(user);
    }

    public User findById(Long id){
        log.info("user Find By Id : return User");
        return userRepository.getById(id);
    }

    public List<UserDTO> delete(Long id) {
        User user = userRepository.getById(id);
        userRepository.delete(user);
        log.info("delete User");
        return findAll();
    }

    private User makeUser(UserDTO userDTO) {
        List<StayLike> stayLikeList = new ArrayList<>();
        List<RentCarLike> rentCarLikeList = new ArrayList<>();
        List<TrainLike> trainLikeList = new ArrayList<>();

        if (userDTO.getStayLikeIdList() != null) {
            for (Long stayLikeId : userDTO.getStayLikeIdList()) {
                stayLikeList.add(stayLikeRepository.getById(stayLikeId));
            }
        }

        if (userDTO.getRentCarLikeIdList() != null) {
            for (Long rentCarLikeId : userDTO.getRentCarLikeIdList()) {
                rentCarLikeList.add(rentCarLikeRepository.getById(rentCarLikeId));
            }
        }

        if (userDTO.getTrainLikeIdList() != null) {
            for (Long trainLikeId : userDTO.getTrainLikeIdList()) {
                trainLikeList.add(trainLikeRepository.getById(trainLikeId));
            }
        }

        return User.builder()
                .userId(userDTO.getUserId())
                .nickname(userDTO.getNickname())
                .loginId(userDTO.getLoginId())
                .password(userDTO.getPassword())
                .stayLikeList(stayLikeList)
                .rentcarLikeList(rentCarLikeList)
                .trainLikeList(trainLikeList)
                .build();
    }

    private UserDTO makeUserAndInfoDTO(User user) {
        UserInfo userInfo = user.getUserInfo();
        UserInfoDTO userInfoDTO = UserInfoDTO.builder()
                .profileImg(userInfo.getProfileImg())
                .userId(user.getUserId())
                .id(userInfo.getId())
                .email(userInfo.getEmail())
                .build();
        List<Long> stayLikeIdList = new ArrayList<>();
        List<Long> rentCarLikeIdList = new ArrayList<>();
        List<Long> trainLikeIdList = new ArrayList<>();

        if (user.getStayLikeList() != null) {
            for (StayLike stayLike : user.getStayLikeList()) {
                stayLikeIdList.add(stayLike.getId());
            }
        }

        if (user.getRentcarLikeList() != null) {
            for (RentCarLike rentCarLike : user.getRentcarLikeList()) {
                rentCarLikeIdList.add(rentCarLike.getRentCarLikeId());
            }
        }

        if (user.getTrainLikeList() != null) {
            for (TrainLike trainLike : user.getTrainLikeList()) {
                trainLikeIdList.add(trainLike.getTrainLikeId());
            }
        }

        return UserDTO.builder()
                .userId(user.getUserId())
                .userInfoDTO(userInfoDTO)
                .stayLikeIdList(stayLikeIdList)
                .rentCarLikeIdList(rentCarLikeIdList)
                .trainLikeIdList(trainLikeIdList)
                .loginId(user.getLoginId())
                .nickname(user.getNickname())
                .password(user.getPassword())
                .build();
    }


    private UserDTO makeUserDTO(User user) {
        List<Long> stayLikeIdList = new ArrayList<>();
        List<Long> rentCarLikeIdList = new ArrayList<>();
        List<Long> trainLikeIdList = new ArrayList<>();

        if (user.getStayLikeList() != null) {
            for (StayLike stayLike : user.getStayLikeList()) {
                stayLikeIdList.add(stayLike.getId());
            }
        }

        if (user.getRentcarLikeList() != null) {
            for (RentCarLike rentCarLike : user.getRentcarLikeList()) {
                rentCarLikeIdList.add(rentCarLike.getRentCarLikeId());
            }
        }

        if (user.getTrainLikeList() != null) {
            for (TrainLike trainLike : user.getTrainLikeList()) {
                trainLikeIdList.add(trainLike.getTrainLikeId());
            }
        }

        return UserDTO.builder()
                .userId(user.getUserId())
                .stayLikeIdList(stayLikeIdList)
                .rentCarLikeIdList(rentCarLikeIdList)
                .trainLikeIdList(trainLikeIdList)
                .loginId(user.getLoginId())
                .nickname(user.getNickname())
                .password(user.getPassword())
                .build();
    }
}