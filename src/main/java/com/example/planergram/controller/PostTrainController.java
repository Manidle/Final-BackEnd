package com.example.planergram.controller;

import com.example.planergram.DTO.PostTrainDTO;
import com.example.planergram.service.PostTrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/post/{postId}")
    public List<PostTrainDTO> postStayFindByTrain(@PathVariable Long postId){
        return postTrainService.findByPost(postId);
    }
}
