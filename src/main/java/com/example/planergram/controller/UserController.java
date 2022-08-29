package com.example.planergram.controller;

import com.example.planergram.model.User;
import com.example.planergram.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public String signUp(@RequestBody User user){
        userService.signup(user);
        return "회원가입이 완료되었습니다.";
    }

    @GetMapping("/user")
    public List<User> findAll() {
        System.out.println("findAll called!");
        return userService.findAll();
    }

    @DeleteMapping("/user/{id}")
    public List<User> delete(@PathVariable Long id){
        return userService.delete(id);
    };

    @PutMapping("/user/{id}")
    public List<User> update(@PathVariable Long id ,@RequestBody User user) {
        userService.update(id,user);
        return userService.update(id,user);
    }
}