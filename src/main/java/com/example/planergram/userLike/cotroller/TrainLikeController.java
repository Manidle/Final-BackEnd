package com.example.planergram.userLike.cotroller;

import com.example.planergram.Response.ResponseService;
import com.example.planergram.userLike.service.TrainLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class TrainLikeController {

    @Autowired
    private TrainLikeService trainLikeService;

    @GetMapping("/v1/like")
    public ResponseEntity<?> clickTrainLike(
            @RequestParam(value="user", defaultValue="0") Long userId,
            @RequestParam(value="train", defaultValue="0") Long trainId){
        try {
            return ResponseEntity.ok(trainLikeService.clickTrainLike(userId,trainId));
        } catch (Exception e){
            return ResponseService.makeResponseEntity("열차 좋아요 클릭을 실패했습니다.",e);
        }
    }

    @GetMapping("/v1/currentuser/like/train/{userId}")
    public ResponseEntity<?> TrainLikeFindByUser(@PathVariable Long userId){
        try {
            return ResponseEntity.ok(trainLikeService.findByUser(userId));
        } catch (Exception e){
            return ResponseService.makeResponseEntity("유저가 좋아요한 열차 리스트 가져오는 것을 실패했습니다.",e);
        }
    }

    @GetMapping("/v1/like/train/{trainId}")
    public ResponseEntity<?> TrainLikeFindByTrain(@PathVariable Long trainId){
        try {
            return ResponseEntity.ok(trainLikeService.findByStay(trainId));
        } catch (Exception e){
            return ResponseService.makeResponseEntity("해당열차의 좋아요 추출을 실패했습니다.",e);
        }
    }

    @GetMapping("/v1/like/train/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        try {
            return ResponseEntity.ok(trainLikeService.findById(id));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("좋아요를 가져오는 것을 실패했습니다.",e);
        }
    }
}