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

    @DeleteMapping("/info/{id}")
    public void delete(@PathVariable int id){
        userInfoService.delete(id);
    };

    @PatchMapping("/info/{id}")
    public UserInfoDTO update(@PathVariable int id ,@RequestBody UserInfoDTO userInfoDTO) {
        return userInfoService.update(id,userInfoDTO);
    }
}