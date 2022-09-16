package com.example.planergram.userLike.cotroller;

import com.example.planergram.Response.ResponseService;
import com.example.planergram.userLike.service.TrainLikeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"기차 좋아요에 대한 API 정보를 제공하는 Controller"})
@RestController
@RequestMapping("/api/auth")
public class TrainLikeController {

    @Autowired
    private TrainLikeService trainLikeService;

    @ApiOperation(value = "특정유저가 특정기차를 좋아요 클릭하는 API")
    @GetMapping("/v1/like/click/train")
    public ResponseEntity<?> clickTrainLike(
            @RequestParam(value="user", defaultValue="0") Long userId,
            @RequestParam(value="train", defaultValue="0") Long trainId){
        try {
            return ResponseEntity.ok(trainLikeService.clickTrainLike(userId,trainId));
        } catch (Exception e){
            return ResponseService.makeResponseEntity("열차 좋아요 클릭을 실패했습니다.",e);
        }
    }

    @ApiOperation(value = "특정유저가 좋아요 누른 기차를 모두 보여주는 API")
    @GetMapping("/v1/getlist/currentuser/like/train/{userId}")
    public ResponseEntity<?> TrainLikeFindByUser(@ApiParam(value = "확인하고싶은 user의 고유id") @PathVariable Long userId){
        try {
            return ResponseEntity.ok(trainLikeService.findByUser(userId));
        } catch (Exception e){
            return ResponseService.makeResponseEntity("유저가 좋아요한 열차 리스트 가져오는 것을 실패했습니다.",e);
        }
    }

    @ApiOperation(value = "특정기차의 좋아요를 모두 보여주는 API")
    @GetMapping("/v1/getlist/like/getlist/train/{trainId}")
    public ResponseEntity<?> TrainLikeFindByTrain(@ApiParam(value = "확인하고싶은 train의 고유id") @PathVariable Long trainId){
        try {
            return ResponseEntity.ok(trainLikeService.findByStay(trainId));
        } catch (Exception e){
            return ResponseService.makeResponseEntity("해당열차의 좋아요 추출을 실패했습니다.",e);
        }
    }

    @ApiOperation(value = "기차&좋아요를 1:1 형태로 모두 보여주는 API")
    @GetMapping("/v1/like/gettrain/{id}")
    public ResponseEntity<?> findById(@ApiParam(value = "확인하고싶은 trainLike의 고유id") @PathVariable Long id){
        try {
            return ResponseEntity.ok(trainLikeService.findById(id));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("좋아요를 가져오는 것을 실패했습니다.",e);
        }
    }
}