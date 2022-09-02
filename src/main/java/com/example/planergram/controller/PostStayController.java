package com.example.planergram.controller;

import com.example.planergram.service.PostStayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/poststay")
public class PostStayController {

    @Autowired
    private PostStayService postStayService;

    @GetMapping("/")
    public String clickStayLike(
            @RequestParam(value="post", defaultValue="0") Long postId,
            @RequestParam(value="stay", defaultValue="0") Long stayId){
        return postStayService.clickStayLike(postId,stayId);
    }
}
