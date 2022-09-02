package com.example.planergram.controller;

import com.example.planergram.service.PostRentCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostRentCarController {

    @Autowired
    private PostRentCarService postRentCarService;

    @GetMapping("/postrentcar")
    public String clickStayLike(
            @RequestParam(value="post", defaultValue="0") Long postId,
            @RequestParam(value="rentcar", defaultValue="0") Long rentCarId){
        return postRentCarService.clickRentCarLike(postId,rentCarId);
    }


}
