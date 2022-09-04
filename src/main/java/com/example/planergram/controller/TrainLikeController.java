package com.example.planergram.controller;

import com.example.planergram.service.TrainLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trainlike")
public class TrainLikeController {

    @Autowired
    private TrainLikeService trainLikeService;

    @GetMapping
    public String clickTrainLike(
            @RequestParam(value="user", defaultValue="0") Long userId,
            @RequestParam(value="train", defaultValue="0") Long trainId){
        return trainLikeService.clickTrainLike(userId,trainId);
    }
}
