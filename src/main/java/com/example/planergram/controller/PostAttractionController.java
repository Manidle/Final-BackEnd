package com.example.planergram.controller;

import com.example.planergram.service.PostAttractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
