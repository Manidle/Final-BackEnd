package com.example.planergram.userLike.cotroller;


import com.example.planergram.Response.ResponseService;
import com.example.planergram.userLike.service.RentCarLikeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"렌트카 좋아요에 대한 API 정보를 제공하는 Controller"})
@RestController
@RequestMapping("/api/auth")
public class RentCarLikeController {

    @Autowired
    private RentCarLikeService rentCarLikeService;

    @ApiOperation(value = "특정유저가 특정렌트카를 좋아요 클릭하는 API")
    @GetMapping("/v1/like/click/rentcar")
    public ResponseEntity<?> clickRentCarLike(
            @RequestParam(value = "user", defaultValue = "0") Long userId,
            @RequestParam(value = "rentcar", defaultValue = "0") Long rentCarId) {
        try {
            return ResponseEntity.ok(rentCarLikeService.clickRentCarLike(userId, rentCarId));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("랜트카 좋아요 클릭을 실패했습니다.", e);
        }
    }

    @ApiOperation(value = "특정유저가 좋아요 누른 렌트카를 모두 보여주는 API")
    @GetMapping("/v1/list/currentuser/like/rentcar/{userId}")
    public ResponseEntity<?> RentCarLikeFindByUser(@ApiParam(value = "확인하고싶은 user의 고유id") @PathVariable Long userId) {
        try {
            return ResponseEntity.ok(rentCarLikeService.findByUser(userId));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("유저가 좋아요한 랜트카 리스트 가져오는 것을 실패했습니다.", e);
        }
    }

    @ApiOperation(value = "특정관광지의 렌트카를 모두 보여주는 API")
    @GetMapping("/v1/list/like/rentcar/{rentcarId}")
    public ResponseEntity<?> RentCarLikeFindByStay(@ApiParam(value = "확인하고싶은 rentcar의 고유id") @PathVariable Long rentcarId) {
        try {
            return ResponseEntity.ok(rentCarLikeService.findByRentCar(rentcarId));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("해당렌트카의 좋아요 추출을 실패했습니다.", e);
        }
    }

    @ApiOperation(value = "렌트카&좋아요를 1:1 형태로 모두 보여주는 API")
    @GetMapping("/v1/like/rentcar/{id}")
    public ResponseEntity<?> findById(@ApiParam(value = "확인하고싶은 rentcarLike의 고유id") @PathVariable Long id) {
        try {
            return ResponseEntity.ok(rentCarLikeService.findById(id));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("좋아요를 가져오는 것을 실패했습니다.", e);
        }
    }
}