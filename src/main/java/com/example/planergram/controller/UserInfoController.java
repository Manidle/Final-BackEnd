package com.example.planergram.controller;

import com.example.planergram.DTO.UserInfoDTO;
import com.example.planergram.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @PostMapping("/info")
    public UserInfoDTO signUp(@RequestBody UserInfoDTO userInfoDTO){
        return userInfoService.signUp(userInfoDTO);
    }

    @GetMapping("/info/{id}")
    public UserInfoDTO findById(@PathVariable int id) {
        return userInfoService.findById(id);
    }
//
//    @DeleteMapping("/info/{id}")
//    public List<User> delete(@PathVariable int id){
//        return userInfoService.delete(id);
//    };
//
//    @PutMapping("/info/{id}")
//    public List<User> update(@PathVariable int id ,@RequestBody User user) {
//        userInfoService.update(id,user);
//        return userInfoService.update(id,user);
//    }
}