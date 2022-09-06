package com.example.planergram.user.cotroller;

import com.example.planergram.Response.ResponseService;
import com.example.planergram.user.DTO.UserDTO;
import com.example.planergram.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public String signUp(@RequestBody UserDTO userDTO){
        userService.signUp(userDTO);
        return "회원가입이 완료되었습니다.";
    }

    @GetMapping("/info/{id}")
    public ResponseEntity<?> getUserAndInfo(@PathVariable Long id){
        try {
            return ResponseEntity.ok(userService.getUserAndInfo(id));
        } catch (Exception e){
            return ResponseService.makeResponseEntity("유저 정보를 가져오는데 실패했습니다.",e);
        }
    }

    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable Long id){
        return userService.getUser(id);
    }

    @PutMapping("/info/{id}")
    public UserDTO updateUserAndInfo(@PathVariable Long id ,@RequestBody UserDTO userDTO) {
        return userService.updateUserAndInfo(id,userDTO);
    }

    @PutMapping("/{id}")
    public UserDTO updateUser(@PathVariable Long id ,@RequestBody UserDTO userDTO) {
        return userService.updateUser(id,userDTO);
    }

    @GetMapping
    public List<UserDTO> findAll() {
        System.out.println("findAll called!");
        return userService.findAll();
    }

    @DeleteMapping("/{id}")
    public List<UserDTO> delete(@PathVariable Long id){
        return userService.delete(id);
    };
}