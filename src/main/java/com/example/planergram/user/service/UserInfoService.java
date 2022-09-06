package com.example.planergram.user.service;

import com.example.planergram.user.DTO.UserInfoDTO;
import com.example.planergram.user.model.User;
import com.example.planergram.user.model.UserInfo;
import com.example.planergram.user.repository.UserInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private UserService userService;

    public UserInfoDTO signUp(UserInfoDTO userInfoDTO) {
        UserInfo userInfo = makeUserInfo(userInfoDTO);
        userInfo = userInfoRepository.save(userInfo);
        return makeUserInfoDTO(userInfo);
    }

    public UserInfo save(User user, UserInfoDTO userInfoDTO){
        UserInfo userInfo = UserInfo.builder()
                .profileImg(userInfoDTO.getProfileImg())
                .email(userInfoDTO.getEmail())
                .user(user)
                .build();
        return userInfoRepository.save(userInfo);
    }

    public UserInfoDTO findById(Long id){
        UserInfo userInfo = userInfoRepository.getById(id);
        return makeUserInfoDTO(userInfo);
    }

//    public void delete(Long id){
//        UserInfo userInfo = userInfoRepository.getById(id);
//        userInfoRepository.delete(userInfo);
//    }

    public void checkByEmail(String email) throws Exception {
        try {
            userInfoRepository.findByEmail(email);
            log.info("userInfo find By Email complete");
        } catch (Exception e){
            throw new Exception("이메일 중복");
        }
    }

    public UserInfoDTO update(Long id,UserInfoDTO userInfoDTO){
        UserInfo userInfo = userInfoRepository.getById(id);
        userInfo.setEmail(userInfoDTO.getEmail());
        userInfo.setProfileImg(userInfoDTO.getProfileImg());
        userInfo = userInfoRepository.save(userInfo);
        log.info("userInfo update complete");
        return makeUserInfoDTO(userInfo);
    }

    public UserInfo makeUserInfo(UserInfoDTO userInfoDTO){
        User user = userService.findById(userInfoDTO.getUserId());
        return UserInfo.builder()
                .user(user)
                .email(userInfoDTO.getEmail())
                .profileImg(userInfoDTO.getProfileImg())
                .build();
    }

    public UserInfoDTO makeUserInfoDTO(UserInfo userInfo){
        return UserInfoDTO.builder()
                .userId(userInfo.getUser().getUserId())
                .id(userInfo.getId())
                .email(userInfo.getEmail())
                .profileImg(userInfo.getProfileImg())
                .build();
    }
}
