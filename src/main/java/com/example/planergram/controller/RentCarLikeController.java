package com.example.planergram.controller;


import com.example.planergram.DTO.RentCarLikeDTO;
import com.example.planergram.service.RentCarLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rentcarlike")
public class RentCarLikeController {

    @Autowired
    private RentCarLikeService rentCarLikeService;

    @GetMapping
    public String clickRentCarLike(
            @RequestParam(value="user", defaultValue="0") Long userId,
            @RequestParam(value="rentCar", defaultValue="0") Long rentCarId){
        return rentCarLikeService.clickRentCarLike(userId,rentCarId);
    }

    @GetMapping("/user/{userId}")
    public List<RentCarLikeDTO> RentCarLikeFindByUser(@PathVariable Long userId){
        return rentCarLikeService.findByUser(userId);
    }

    @GetMapping("/rentcar/{rentcarId}")
    public List<RentCarLikeDTO> RentCarLikeFindByStay(@PathVariable Long rentcarId){
        return rentCarLikeService.findByRentCar(rentcarId);
    }

    @GetMapping("/{id}")
    public RentCarLikeDTO findById(@PathVariable Long id){
        return rentCarLikeService.findById(id);
    }
}
