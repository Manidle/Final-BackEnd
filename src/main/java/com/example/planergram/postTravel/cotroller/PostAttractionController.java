package com.example.planergram.postTravel.cotroller;

import com.example.planergram.Response.ResponseService;
import com.example.planergram.postTravel.service.PostAttractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/postattraction")
public class PostAttractionController {

    @Autowired
    private PostAttractionService postAttractionService;

    @GetMapping
    public ResponseEntity<?> clickPostAttraction(
            @RequestParam(value="post", defaultValue="0") Long postId,
            @RequestParam(value="stay", defaultValue="0") Long attractionId) {
        try {
            return ResponseEntity.ok(postAttractionService.clickPostAttraction(postId, attractionId));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("관광지 불러오기를 실패했습니다.",e);
        }
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<?> postAttractionFindByPost(@PathVariable Long postId){
        try {
            return ResponseEntity.ok(postAttractionService.findByPost(postId));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("저장된 관광지 불러오기를 실패하였습니다..",e);
        }
    }

    @GetMapping("/attraction/{attractionId}")
    public ResponseEntity<?> postAttractionFindByAttraction(@PathVariable Long attractionId){
        try {
            return ResponseEntity.ok(postAttractionService.findByAttraction(attractionId));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("해당 관광지가 등록된 게시글을 불러오는데 실패하였습니다.",e);
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        try {
            return ResponseEntity.ok(postAttractionService.findById(id));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("저장된 postAttraction을 불러오기 실패하였습니다.",e);
        }
    }
}