package com.example.planergram.user.cotroller;

import com.example.planergram.Response.ResponseService;
import com.example.planergram.user.DTO.UserInfoDTO;
import com.example.planergram.user.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/v1/getinfo/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(userInfoService.findById(id));
        } catch (Exception e){
            return ResponseService.makeResponseEntity("유저 정보를 조회할 수 없습니다.", e);
        }
    }

    @PatchMapping("/v1/modifyinfo/{id}")
    public ResponseEntity<?> update(@PathVariable Long id ,@RequestBody UserInfoDTO userInfoDTO) {
        try {
            return ResponseEntity.ok(userInfoService.update(id,userInfoDTO));
        } catch (Exception e){
            return ResponseService.makeResponseEntity("업데이트를 할 수 없습니다.",e);
        }
    }
}