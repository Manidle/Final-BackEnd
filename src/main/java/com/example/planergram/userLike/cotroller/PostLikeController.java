package com.example.planergram.userLike.cotroller;

import com.example.planergram.Response.ResponseService;
import com.example.planergram.userLike.service.PostLikeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@Slf4j
public class PostLikeController {

    @Autowired
    private PostLikeService postLikeService;

    @GetMapping("/v1/like/lick/post")
    public ResponseEntity<?> clickPostLike(@RequestParam(value = "user", defaultValue = "0") Long userId,
                                           @RequestParam(value = "post", defaultValue = "0") Long postId) {
        try {
            log.info("postLike Click 발생 : userId : {}     postId : {}",userId,postId);
            return ResponseEntity.ok(postLikeService.clickPostLike(userId, postId));
        } catch (Exception e){
            return ResponseService.makeResponseEntity("게시글 좋아요 클릭을 실패했습니다.",e);
        }

    }

    @GetMapping("/v1/currentuser/like/post/{userId}")
    public ResponseEntity<?> postLikeFindByUser(@PathVariable Long userId){
        try {
            return ResponseEntity.ok(postLikeService.findByUser(userId));
        } catch (Exception e){
            return ResponseService.makeResponseEntity("유저가 좋아요한 게시글 리스트 가져오는 것을 실패했습니다.",e);
        }
    }

    @GetMapping("/v1/like/post/{postId}")
    public ResponseEntity<?> postLikeFindByPost(@PathVariable Long postId){
        try {
            return ResponseEntity.ok(postLikeService.findByPost(postId));
        } catch (Exception e){
            return ResponseService.makeResponseEntity("해당게시글의 좋아요 추출을 실패했습니다.",e);
        }
    }

    @GetMapping("/v1/like/post/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        try {
            return ResponseEntity.ok(postLikeService.findById(id));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("좋아요를 가져오는 것을 실패했습니다.",e);
        }
    }
}