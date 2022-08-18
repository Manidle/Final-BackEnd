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

    @PostMapping("/join")
    public String signUp(User user){
        userService.회원가입(user);
        return "회원가입이 완료되었습니다.";
    }

    @GetMapping("/findall")
    public List<User> findAll() {
        System.out.println("findAll called!");
        return userService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public List<User> delete(@PathVariable int id){
        return userService.delete(id);
    };

    @PutMapping("/update/{id}")
    public List<User> update(@PathVariable int id, @RequestBody User user) {
        userService.update(id,user);
        return userService.update(id,user);
    }
}
