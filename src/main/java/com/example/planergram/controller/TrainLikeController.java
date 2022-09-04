package com.example.planergram.controller;

import com.example.planergram.DTO.StayLikeDTO;
import com.example.planergram.DTO.TrainLikeDTO;
import com.example.planergram.service.TrainLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/user/{userId}")
    public List<TrainLikeDTO> TrainLikeFindByUser(@PathVariable Long userId){
        return trainLikeService.findByUser(userId);
    }

    @GetMapping("/train/{trainId}")
    public List<TrainLikeDTO> StayLikeFindByTrain(@PathVariable Long trainId){
        return trainLikeService.findByStay(trainId);
    }

    @GetMapping("/{id}")
    public TrainLikeDTO findById(@PathVariable Long id){
        return trainLikeService.findById(id);
    }
}