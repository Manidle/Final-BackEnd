package com.example.planergram.user.cotroller;

import com.example.planergram.Response.ResponseService;
import com.example.planergram.user.DTO.UserInfoDTO;
import com.example.planergram.user.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"UserInfo API 정보를 제공하는 Controller"})
@RestController
@RequestMapping("/api/auth")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @ApiOperation(value = "특정유저의 상세정보만 보여주는 API")
    @GetMapping("/v1/info/{id}")
    public ResponseEntity<?> findById(@ApiParam(value = "확인하고싶은 user의 고유id") @PathVariable Long id) {
        try {
            return ResponseEntity.ok(userInfoService.findById(id));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("유저 정보를 조회할 수 없습니다.", e);
        }
    }

    @ApiOperation(value = "특정유저의 상세정보만 수정하는 API")
    @PatchMapping("/v1/modify/info/{id}")
    public ResponseEntity<?> update(@ApiParam(value = "수정하고싶은 user의 고유id") @PathVariable Long id, @RequestBody UserInfoDTO userInfoDTO) {
        try {
            return ResponseEntity.ok(userInfoService.update(id, userInfoDTO));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("업데이트를 할 수 없습니다.", e);
        }
    }
}