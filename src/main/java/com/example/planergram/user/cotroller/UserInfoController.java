package com.example.planergram.user.cotroller;

import com.example.planergram.user.DTO.UserInfoDTO;
import com.example.planergram.user.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/info")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @PostMapping("/")
    public UserInfoDTO signUp(@RequestBody UserInfoDTO userInfoDTO){
        return userInfoService.signUp(userInfoDTO);
    }

    @GetMapping("/{id}")
    public UserInfoDTO findById(@PathVariable Long id) {
        return userInfoService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        userInfoService.delete(id);
    };

    @PatchMapping("/{id}")
    public UserInfoDTO update(@PathVariable Long id ,@RequestBody UserInfoDTO userInfoDTO) {
        return userInfoService.update(id,userInfoDTO);
    }
}