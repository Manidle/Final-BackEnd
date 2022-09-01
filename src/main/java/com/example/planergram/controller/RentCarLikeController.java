package com.example.planergram.controller;


import com.example.planergram.DTO.RentCarLikeDTO;
import com.example.planergram.service.RentCarLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RentCarLikeController {

    @Autowired
    private RentCarLikeService rentCarLikeService;

    @GetMapping("/rentcarlike")
    public String clickRentCarLike(
            @RequestParam(value="user", defaultValue="0") Long userId,
            @RequestParam(value="rentCar", defaultValue="0") Long rentCarId){
        return rentCarLikeService.clickRentCarLike(userId,rentCarId);
    }

    @GetMapping("/rentcarlike/user/{userId}")
    public List<RentCarLikeDTO> RentCarLikeFindByUser(@PathVariable Long userId){
        return rentCarLikeService.findByUser(userId);
    }



}
