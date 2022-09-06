package com.example.planergram.postTravel.cotroller;

import com.example.planergram.Response.ResponseService;
import com.example.planergram.postTravel.service.PostRentCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/postrentcar")
public class PostRentCarController {

    @Autowired
    private PostRentCarService postRentCarService;

    @GetMapping
    public ResponseEntity<?> clickPostRentCar(
            @RequestParam(value="post", defaultValue="0") Long postId,
            @RequestParam(value="rentcar", defaultValue="0") Long rentCarId){
        try {
            return ResponseEntity.ok(postRentCarService.clickRentCarLike(postId,rentCarId));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("렌트카 불러오기를 실패하였습니다.",e);
        }
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<?> postRentCarFindByPost(@PathVariable Long postId){
        try {
            return ResponseEntity.ok(postRentCarService.findByPost(postId));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("저장된 렌트카 불러오기를 실패하였습니다.",e);
        }
    }

    @GetMapping("/rentCar/{rentCarId}")
    public ResponseEntity<?> postRentCarFindByRentCar(@PathVariable Long rentCarId){
        try {
            return ResponseEntity.ok(postRentCarService.findByRentCar(rentCarId));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("해당 렌트카가 등록된 게시글을 불러오는데 실패하였습니다.",e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        try {
            return ResponseEntity.ok(postRentCarService.findById(id));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("저장된 postRentCar 불러오기 실패하였습니다.",e);
        }
    }
}