package com.example.planergram.user.cotroller;

import com.example.planergram.Response.ResponseService;
import com.example.planergram.user.DTO.UserInfoDTO;
import com.example.planergram.user.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/info")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

//    @PostMapping("/")
//    public UserInfoDTO signUp(@RequestBody UserInfoDTO userInfoDTO){
//        return userInfoService.signUp(userInfoDTO);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(userInfoService.findById(id));
        } catch (Exception e){
            return ResponseService.makeResponseEntity("유저 정보를 조회할 수 없습니다.", e);
        }
    }

//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable Long id){
//        userInfoService.delete(id);
//    };

    @PatchMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id ,@RequestBody UserInfoDTO userInfoDTO) {
        try {
            return ResponseEntity.ok(userInfoService.update(id,userInfoDTO));
        } catch (Exception e){
            return ResponseService.makeResponseEntity("업데이트를 할 수 없습니다.",e);
        }
    }
}