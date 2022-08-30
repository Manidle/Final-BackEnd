package com.example.planergram.service;

import com.example.planergram.DTO.UserDTO;
import com.example.planergram.DTO.UserInfoDTO;
import com.example.planergram.model.StayLike;
import com.example.planergram.model.User;
import com.example.planergram.model.UserInfo;
import com.example.planergram.repository.StayLikeRepository;
import com.example.planergram.repository.UserInfoRepository;
import com.example.planergram.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private StayLikeRepository stayLikeRepository;

    public String signUp(UserDTO userDTO){
        User user = User.builder()
                .password(userDTO.getPassword())
                .nickname(userDTO.getNickname())
                .loginId(userDTO.getLoginId())
                .build();
        user = userRepository.save(user);
        UserInfo userInfo = UserInfo.builder()
                .profileImg(userDTO.getUserInfoDTO().getProfileImg())
                .email(userDTO.getUserInfoDTO().getEmail())
                .user(user)
                .build();
        userInfo = userInfoRepository.save(userInfo);
        user.setUserInfo(userInfo);
        user = userRepository.save(user);
        System.out.println(makeUserAndInfoDTO(user));
        return "회원가입이 완료되었습니다";
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public List<User> delete(Long id) {
        final Optional<User> foundTodo = userRepository.findById(id);
        foundTodo.ifPresent(user -> {
            userRepository.delete(user);
        });
        return userRepository.findAll();
    }

    public List<User> update(Long id, User user) {

        final Optional<User> founduser = userRepository.findById(id);

        founduser.ifPresent(newuser -> {
//            newuser.setUsername(user.getUsername());
            newuser.setPassword(user.getPassword());
//            newuser.setEmail(user.getEmail());
            userRepository.save(newuser);
        });
        return userRepository.findAll();
    }

    public UserDTO getUserAndInfo(Long id) {
        User user = userRepository.getById(id);
        return makeUserAndInfoDTO(user);
    }

    public UserDTO getUser(Long id){
        User user = userRepository.getById(id);
        return makeUserDTO(user);
    }

    private User makeUser(UserDTO userDTO){
        UserInfo userInfo = userInfoRepository.getById(userDTO.getUserInfoDTO().getId());
        List<StayLike> stayLikeList = new ArrayList<>();
        if (userDTO.getStayLikeIdList() != null){
            for (Long stayLikeId : userDTO.getStayLikeIdList()){
                stayLikeList.add(stayLikeRepository.getById(stayLikeId));
            }
        }
        return User.builder()
                .id(userDTO.getId())
//                .userInfo(userInfo)
                .nickname(userDTO.getNickname())
                .loginId(userDTO.getLoginId())
                .password(userDTO.getPassword())
                .stayLikeList(stayLikeList)
                .build();
    }

    private UserDTO makeUserAndInfoDTO(User user){
        UserInfo userInfo = user.getUserInfo();
        UserInfoDTO userInfoDTO = UserInfoDTO.builder()
                .profileImg(userInfo.getProfileImg())
                .userId(user.getId())
                .id(userInfo.getId())
                .email(userInfo.getEmail())
                .build();
        List<Long> stayLikeIdList = new ArrayList<>();
        if (user.getStayLikeList() != null) {
            for (StayLike stayLike : user.getStayLikeList()) {
                stayLikeIdList.add(stayLike.getId());
            }
        }
        return UserDTO.builder()
                .id(user.getId())
                .userInfoDTO(userInfoDTO)
                .stayLikeIdList(stayLikeIdList)
                .loginId(user.getLoginId())
                .nickname(user.getNickname())
                .password(user.getPassword())
                .build();
    }
    private UserDTO makeUserDTO(User user){
        List<Long> stayLikeIdList = new ArrayList<>();
        if (user.getStayLikeList() != null) {
            for (StayLike stayLike : user.getStayLikeList()) {
                stayLikeIdList.add(stayLike.getId());
            }
        }
        return UserDTO.builder()
                .id(user.getId())
                .stayLikeIdList(stayLikeIdList)
                .loginId(user.getLoginId())
                .nickname(user.getNickname())
                .password(user.getPassword())
                .build();
    }
}