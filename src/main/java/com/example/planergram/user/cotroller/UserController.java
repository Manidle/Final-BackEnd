package com.example.planergram.user.cotroller;

import com.example.planergram.Response.ResponseService;
import com.example.planergram.travelContents.repository.PlatformRepository;
import com.example.planergram.user.DTO.UserDTO;
import com.example.planergram.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"User 혹은 UserInfo와 함께 API 정보를 제공하는 Controller"})
@RestController
@Slf4j
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private PlatformRepository platformRepository;

    @ApiOperation(value = "회원가입 API")
    @PostMapping("/v1/register")
    public ResponseEntity<?> signUp(@RequestBody UserDTO userDTO){
        try {
            userService.signUp(userDTO);
            return ResponseEntity.ok("회원가입이 완료되었습니다.");
        } catch (Exception e){
            return ResponseService.makeResponseEntity("회원가입에 실패했습니다.",e);
        }
    }

    @ApiOperation(value = "특정유저의 기본정보 및 세부정보를 보여주는 API")
    @GetMapping("/auth/v1/user/info/{id}")
    public ResponseEntity<?> getUserAndInfo(@ApiParam(value = "확인하고싶은 user의 고유id") @PathVariable Long id){
        try {
            return ResponseEntity.ok(userService.getUserAndInfo(id));
        } catch (Exception e){
            return ResponseService.makeResponseEntity("유저 정보를 가져오는데 실패했습니다.",e);
        }
    }

    @ApiOperation(value = "특정유저의 기본정보만 보여주는 API")
    @GetMapping("/auth/v1/user/{id}")
    public ResponseEntity<?> getUser(@ApiParam(value = "확인하고싶은 user의 고유id") @PathVariable Long id){
        try {
            return ResponseEntity.ok( userService.getUser(id));
        } catch (Exception e){
            return ResponseService.makeResponseEntity("유저 정보를 가져오는데 실패했습니다.",e);
        }
    }

    @ApiOperation(value = "특정유저의 기본정보 및 세부정보를 수정하는 API")
    @PutMapping("/auth/v1/modify/user/info/{id}")
    public ResponseEntity<?> updateUserAndInfo(@ApiParam(value = "수정하고싶은 user의 고유id") @PathVariable Long id ,@RequestBody UserDTO userDTO) {
        try {
            return ResponseEntity.ok(userService.updateUserAndInfo(id,userDTO));
        } catch (Exception e){
            return ResponseService.makeResponseEntity("유저 정보 변경에 실패했습니다.",e);
        }
    }

    @ApiOperation(value = "특정유저의 기본정보만 수정하는 API")
    @PutMapping("/auth/v1/modify/user/{id}")
    public ResponseEntity<?> updateUser(@ApiParam(value = "수정하고싶은 user의 고유id") @PathVariable Long id ,@RequestBody UserDTO userDTO) {
        try {
            return ResponseEntity.ok(userService.updateUser(id,userDTO));
        } catch (Exception e){
            return ResponseService.makeResponseEntity("유저 정보 변경에 실패했습니다.",e);
        }
    }

    @ApiOperation(value = "모든유저를 모두 보여주는 API")
    @GetMapping("/admin/auth/v1/list/user")
    public ResponseEntity<?> findAll() {
        try {
            return ResponseEntity.ok(userService.findAll());
        } catch (Exception e){
            return ResponseService.makeResponseEntity("유저 정보 조회에 실패했습니다.",e);
        }
    }

    @ApiOperation(value = "유저를 탈퇴시키는 API")
    @DeleteMapping("/admin/auth/v1/user/{id}")
    public ResponseEntity<?> delete(@ApiParam(value = "삭제하고싶은 user의 고유id") @PathVariable Long id){
        try {
            return ResponseEntity.ok(userService.delete(id));
        } catch (Exception e){
            return ResponseService.makeResponseEntity("유저 정보 삭제에 실패했습니다.",e);
        }
    }
}