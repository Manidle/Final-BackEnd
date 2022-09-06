package com.example.planergram.userLike.cotroller;

import com.example.planergram.Response.ResponseService;
import com.example.planergram.userLike.DTO.TrainLikeDTO;
import com.example.planergram.userLike.service.TrainLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trainlike")
public class TrainLikeController {

    @Autowired
    private TrainLikeService trainLikeService;

    @GetMapping
    public ResponseEntity<?> clickTrainLike(
            @RequestParam(value="user", defaultValue="0") Long userId,
            @RequestParam(value="train", defaultValue="0") Long trainId){
        try {
            return ResponseEntity.ok(trainLikeService.clickTrainLike(userId,trainId));
        } catch (Exception e){
            return ResponseService.makeResponseEntity("열차 좋아요 클릭을 실패했습니다.",e);
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> TrainLikeFindByUser(@PathVariable Long userId){
        try {
            return ResponseEntity.ok(trainLikeService.findByUser(userId));
        } catch (Exception e){
            return ResponseService.makeResponseEntity("유저가 좋아요한 열차 리스트 가져오는 것을 실패했습니다.",e);
        }
    }

    @GetMapping("/train/{trainId}")
    public ResponseEntity<?> StayLikeFindByTrain(@PathVariable Long trainId){
        try {
            return ResponseEntity.ok(trainLikeService.findByStay(trainId));
        } catch (Exception e){
            return ResponseService.makeResponseEntity("유저가 좋아요한 열차 리스트 가져오는 것을 실패했습니다.",e);
        }
    }

    @GetMapping("/{id}")
    public TrainLikeDTO findById(@PathVariable Long id){
        return trainLikeService.findById(id);
    }
}