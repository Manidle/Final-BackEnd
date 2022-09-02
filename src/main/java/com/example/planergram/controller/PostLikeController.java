package com.example.planergram.controller;

import com.example.planergram.DTO.PostLikeDTO;
import com.example.planergram.service.PostLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postlike")
public class PostLikeController {

    @Autowired
    private PostLikeService postLikeService;

    @GetMapping
    public String clickPostLike(@RequestParam(value = "user", defaultValue = "0") Long userId,
                                @RequestParam(value = "post", defaultValue = "0") Long postId) {
        return postLikeService.clickPostLike(userId, postId);
    }

    @GetMapping("/user/{userId}")
    public List<PostLikeDTO> postLikeFindByUser(@PathVariable Long userId){
        return postLikeService.findByUser(userId);
    }

    @GetMapping("/post/{postId}")
    public List<PostLikeDTO> postLikeFindByPost(@PathVariable Long postId){
        return postLikeService.findByPost(postId);
    }

    @GetMapping("/{id}")
    public PostLikeDTO findById(@PathVariable Long id){
        return postLikeService.findById(id);
    }
}