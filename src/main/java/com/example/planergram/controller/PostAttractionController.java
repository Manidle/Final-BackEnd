package com.example.planergram.controller;

import com.example.planergram.DTO.PostAttractionDTO;
import com.example.planergram.service.PostAttractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postattraction")
public class PostAttractionController {

    @Autowired
    private PostAttractionService postAttractionService;

    @GetMapping("/")
    public String clickPostAttraction(
            @RequestParam(value="post", defaultValue="0") Long postId,
            @RequestParam(value="stay", defaultValue="0") Long attractionId) {
    return postAttractionService.clickPostAttraction(postId, attractionId);
    }

    @GetMapping("/post/{postId}")
    public List<PostAttractionDTO> postAttractionFindByPost(@PathVariable Long postId){
        return postAttractionService.findByPost(postId);
    }

    @GetMapping("/attraction/{attractionId}")
    public List<PostAttractionDTO> postAttractionFindByAttraction(@PathVariable Long attractionId){
        return postAttractionService.findByAttraction(attractionId);
    }
}
