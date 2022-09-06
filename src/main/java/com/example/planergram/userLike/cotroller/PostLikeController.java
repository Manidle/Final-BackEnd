package com.example.planergram.userLike.cotroller;

import com.example.planergram.Response.ResponseService;
import com.example.planergram.userLike.DTO.PostLikeDTO;
import com.example.planergram.userLike.service.PostLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postlike")
public class PostLikeController {

    @Autowired
    private PostLikeService postLikeService;

    @GetMapping
    public ResponseEntity<?> clickPostLike(@RequestParam(value = "user", defaultValue = "0") Long userId,
                                           @RequestParam(value = "post", defaultValue = "0") Long postId) {
        try {
            return ResponseEntity.ok(postLikeService.clickPostLike(userId, postId));
        } catch (Exception e){
            return ResponseService.makeResponseEntity("게시글 좋아요 클릭을 실패했습니다.",e);
        }

    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> postLikeFindByUser(@PathVariable Long userId){
        try {
            return ResponseEntity.ok(postLikeService.findByUser(userId));
        } catch (Exception e){
            return ResponseService.makeResponseEntity("유저가 좋아요한 게시글 리스트 가져오는 것을 실패했습니다.",e);
        }
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<?> postLikeFindByPost(@PathVariable Long postId){
        try {
            return ResponseEntity.ok(postLikeService.findByPost(postId));
        } catch (Exception e){
            return ResponseService.makeResponseEntity("유저가 좋아요한 게시글 리스트 가져오는 것을 실패했습니다.",e);
        }
    }

    @GetMapping("/{id}")
    public PostLikeDTO findById(@PathVariable Long id){
        return postLikeService.findById(id);
    }
}