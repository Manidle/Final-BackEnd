package com.example.planergram.controller;

import com.example.planergram.DTO.PostLikeDTO;
import com.example.planergram.service.PostLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostLikeController {

    @Autowired
    private PostLikeService postLikeService;

    @GetMapping("/postlike")
    public String clickPostLike(@RequestParam(value = "user", defaultValue = "0") Long userId,
                                @RequestParam(value = "post", defaultValue = "0") Long postId) {
        return postLikeService.clickPostLike(userId, postId);
    }

    @GetMapping("/postlike/user/{userId}")
    public List<PostLikeDTO> postLikeFindByUser(@PathVariable Long userId){
        return postLikeService.findByUser(userId);
    }

    @GetMapping("/postlike/post/{postId}")
    public List<PostLikeDTO> postLikeFindByPost(@PathVariable Long postId){
        return postLikeService.findByPost(postId);
    }

    @GetMapping("/postlike/{id}")
    public PostLikeDTO findById(@PathVariable Long id){
        return postLikeService.findById(id);
    }
}