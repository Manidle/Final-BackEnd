package com.example.planergram.postTravel.cotroller;

import com.example.planergram.Response.ResponseService;
import com.example.planergram.postTravel.service.PostTrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posttrain")
public class PostTrainController {

    @Autowired
    private PostTrainService postTrainService;

    @GetMapping
    public ResponseEntity<?> clickTrainLike(
            @RequestParam(value="post", defaultValue="0") Long postId,
            @RequestParam(value="train", defaultValue="0") Long trainId){
        try {
            return ResponseEntity.ok(postTrainService.clickTrainLike(postId,trainId ));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("저장된 postRentCar 불러오기 실패하였습니다.",e);
        }
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<?> postStayFindByPost(@PathVariable Long postId){
        try {
            return ResponseEntity.ok(postTrainService.findByPost(postId));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("저장된 렌트카 불러오기를 실패하였습니다.",e);
        }
    }

    @GetMapping("/train/{trainId}")
    public ResponseEntity<?> postStayFindByTrain(@PathVariable Long trainId){
        try {
            return ResponseEntity.ok(postTrainService.findByTrain(trainId));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("해당 렌트카가 등록된 게시글을 불러오는데 실패하였습니다.",e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        try {
            return ResponseEntity.ok(postTrainService.findById(id));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("저장된 postRentCar 불러오기 실패하였습니다.",e);
        }
    }
}
