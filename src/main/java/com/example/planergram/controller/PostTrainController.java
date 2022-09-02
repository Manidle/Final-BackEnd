package com.example.planergram.controller;

import com.example.planergram.service.PostTrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posttrain")
public class PostTrainController {

    @Autowired
    private PostTrainService postTrainService;

    @GetMapping("/")
    public String clickTrainLike(
            @RequestParam(value="post", defaultValue="0") Long postId,
            @RequestParam(value="train", defaultValue="0") Long trainId){
        return postTrainService.clickTrainLike(postId,trainId);
    }
}
