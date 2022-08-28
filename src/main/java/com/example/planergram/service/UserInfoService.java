package com.example.planergram.service;

import com.example.planergram.DTO.UserInfoDTO;
import com.example.planergram.model.User;
import com.example.planergram.model.UserInfo;
import com.example.planergram.repository.UserInfoRepository;
import com.example.planergram.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private UserRepository userRepository;

    public UserInfoDTO signUp(UserInfoDTO userInfoDTO) {
        UserInfo userInfo = makeUserInfo(userInfoDTO);
        userInfo = userInfoRepository.save(userInfo);
        return makeUserInfoDTO(userInfo);
    }

    private UserInfo makeUserInfo(UserInfoDTO userInfoDTO){
        User user = userRepository.getById(userInfoDTO.getUserId());
        return UserInfo.builder()
                .user(user)
                .email(userInfoDTO.getEmail())
                .profileImg(userInfoDTO.getProfileImg())
                .build();
    }

    private UserInfoDTO makeUserInfoDTO(UserInfo userInfo){
        return UserInfoDTO.builder()
                .userId(userInfo.getUser().getId())
                .id(userInfo.getId())
                .email(userInfo.getEmail())
                .profileImg(userInfo.getProfileImg())
                .build();
    }
}
