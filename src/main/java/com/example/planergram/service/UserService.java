package com.example.planergram.service;

import com.example.planergram.DTO.UserDTO;
import com.example.planergram.model.User;
import com.example.planergram.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // 회원가입
    public User save(UserDTO userDTO) throws Exception {
        User user = makeUser(userDTO);
        return userRepository.save(user);
    }

    // 회원조회
    public List<User> findAll() {
        return userRepository.findAll();
    }

    //회원 업데이트
    public User update(Long id, UserDTO userDTO) throws Exception {
        User findUser = userRepository.findById(id).orElseThrow(Exception::new);
        findUser.setLoginId(userDTO.getLoginId());
        findUser.setPassword(userDTO.getPassword());
        findUser.setNickname(userDTO.getNickname());
        return userRepository.save(findUser);
    }

    //회원삭제
    public User delete(Long id) throws Exception {
        final User user = userRepository.findById(id).orElseThrow(Exception::new);
        userRepository.delete(user);
        return user;
    }

    //make
    public UserDTO makeUserDTO(User user) {
        return UserDTO
                .builder()
                .userId(user.getUserId())
                .loginId(user.getLoginId())
                .password(user.getPassword())
                .nickname(user.getNickname())
                .build();
    }

    public User makeUser(UserDTO userDTO) {
        return User
                .builder()
                .userId(userDTO.getUserId())
                .loginId(userDTO.getLoginId())
                .password(userDTO.getPassword())
                .nickname(userDTO.getNickname())
                .build();
    }
}