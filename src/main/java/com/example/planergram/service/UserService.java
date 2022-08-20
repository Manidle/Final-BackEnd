package com.example.planergram.service;

import com.example.planergram.model.User;
import com.example.planergram.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public String 회원가입(User user){
        userRepository.save(user);
        return "회원가입이 완료되었습니다!";
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public List<User> delete(int id) {
        final Optional<User> foundTodo = userRepository.findById(id);
        foundTodo.ifPresent(user -> {
            userRepository.delete(user);
        });
        return userRepository.findAll();
    }

    public List<User> update(int id, User user) {

        final Optional<User> founduser = userRepository.findById(user.getId());

        founduser.ifPresent(newuser -> {
            newuser.setUserId(user.getUserId());
            newuser.setPassword(user.getPassword());
            newuser.setEmail(user.getEmail());
            userRepository.save(newuser);
        });
        return userRepository.findAll();
    }
}
