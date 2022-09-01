package com.example.planergram.controller;

import com.example.planergram.service.PostLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostLikeController {

    @Autowired
    private PostLikeService postLikeService;

    @GetMapping("/postlike")
    public String clickPostLike(@RequestParam(value="user", defaultValue="0") Long userId,
                                @RequestParam(value="post", defaultValue="0") Long postId){
        return postLikeService.clickPostLike(userId, postId);
    }
