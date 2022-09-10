package com.example.planergram.user.cotroller;

import com.example.planergram.Response.ResponseService;
import com.example.planergram.user.DTO.UserDTO;
import com.example.planergram.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"API 정보를 제공하는 Controller"})
@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> signUp(@RequestBody UserDTO userDTO){
        try {
            userService.signUp(userDTO);
            return ResponseEntity.ok("회원가입이 완료되었습니다.");
        } catch (Exception e){
            return ResponseService.makeResponseEntity("회원가입에 실패했습니다.",e);

        }
    }

    @GetMapping("/info/{id}")
    public ResponseEntity<?> getUserAndInfo(@ApiParam(value = "id값") @PathVariable Long id){
        try {
            return ResponseEntity.ok(userService.getUserAndInfo(id));
        } catch (Exception e){
            return ResponseService.makeResponseEntity("유저 정보를 가져오는데 실패했습니다.",e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id){
        try {
            return ResponseEntity.ok( userService.getUser(id));
        } catch (Exception e){
            return ResponseService.makeResponseEntity("유저 정보를 가져오는데 실패했습니다.",e);
        }
    }

    @PutMapping("/info/{id}")
    public ResponseEntity<?> updateUserAndInfo(@PathVariable Long id ,@RequestBody UserDTO userDTO) {
        try {
            return ResponseEntity.ok(userService.updateUserAndInfo(id,userDTO));
        } catch (Exception e){
            return ResponseService.makeResponseEntity("유저 정보 변경에 실패했습니다.",e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id ,@RequestBody UserDTO userDTO) {
        try {
            return ResponseEntity.ok(userService.updateUser(id,userDTO));
        } catch (Exception e){
            return ResponseService.makeResponseEntity("유저 정보 변경에 실패했습니다.",e);
        }
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        try {
            return ResponseEntity.ok(userService.findAll());
        } catch (Exception e){
            return ResponseService.makeResponseEntity("유저 정보 조회에 실패했습니다.",e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            return ResponseEntity.ok(userService.delete(id));
        } catch (Exception e){
            return ResponseService.makeResponseEntity("유저 정보 삭제에 실패했습니다.",e);
        }
    }
}