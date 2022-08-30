package com.example.planergram.controller;

import com.example.planergram.DTO.UserDTO;
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
    public String signUp(@RequestBody UserDTO userDTO){
        System.out.println(userDTO);
        userService.signUp(userDTO);
        return "회원가입이 완료되었습니다.";
    }

    @GetMapping("/user/info/{id}")
    public UserDTO getUserAndInfo(@PathVariable Long id){
        return userService.getUserAndInfo(id);
    }

    @GetMapping("/user/{id}")
    public UserDTO getUser(@PathVariable Long id){
        return userService.getUser(id);
    }

    @PutMapping("/user/info/{id}")
    public UserDTO updateUserAndInfo(@PathVariable Long id ,@RequestBody UserDTO userDTO) {
        return userService.updateUserAndInfo(id,userDTO);
    }

    @PutMapping("/user/{id}")
    public UserDTO updateUser(@PathVariable Long id ,@RequestBody UserDTO userDTO) {
        return userService.updateUser(id,userDTO);
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
}