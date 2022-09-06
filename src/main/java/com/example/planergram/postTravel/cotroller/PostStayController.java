package com.example.planergram.postTravel.cotroller;

import com.example.planergram.Response.ResponseService;
import com.example.planergram.postTravel.service.PostStayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/poststay")
public class PostStayController {

    @Autowired
    private PostStayService postStayService;

    @GetMapping
    public ResponseEntity<?> clickPostStay(
            @RequestParam(value="post", defaultValue="0") Long postId,
            @RequestParam(value="stay", defaultValue="0") Long stayId){
        try {
            return ResponseEntity.ok(postStayService.clickStayLike(postId, stayId));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("숙소 불러오기를 실패하였습니다.",e);
        }
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<?> postStayFindByPost(@PathVariable Long postId){
        try {
            return ResponseEntity.ok(postStayService.findByPost(postId));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("저장된 렌트카 불러오기를 실패하였습니다.",e);
        }
    }

    @GetMapping("/stay/{stayId}")
    public ResponseEntity<?> postStayFindByStay(@PathVariable Long stayId){
        try {
            return ResponseEntity.ok(postStayService.findByStay(stayId));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("해당 렌트카가 등록된 게시글을 불러오는데 실패하였습니다.",e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        try {
            return ResponseEntity.ok(postStayService.findById(id));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("해당 렌트카가 등록된 게시글을 불러오는데 실패하였습니다.",e);
        }
    }
}