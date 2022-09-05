package com.example.planergram.controller;

import com.example.planergram.service.AttractionLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/attractionlike")
public class AttractionLikeController {
    @Autowired
    private AttractionLikeService attractionLikeService;

    @GetMapping("/")
    public String clickAttractionLike(
            @RequestParam(value="user", defaultValue="0") Long userId,
            @RequestParam(value="attraction", defaultValue ="0") Long attractionId
    ){
        return attractionLikeService.clickAttractionLike(userId, attractionId);
    }
}
