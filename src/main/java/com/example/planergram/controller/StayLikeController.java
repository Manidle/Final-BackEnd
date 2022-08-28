package com.example.planergram.controller;

import com.example.planergram.DTO.StayDTO;
import com.example.planergram.DTO.StayLikeDTO;
import com.example.planergram.service.StayLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StayLikeController {

    @Autowired
    private StayLikeService stayLikeService;

    @GetMapping("/staylike")
    public String clickStayLike(
            @RequestParam(value="user", defaultValue="0") int userId,
            @RequestParam(value="stay", defaultValue="0") int stayId){
        return stayLikeService.clickStayLike(userId,stayId);
    }

    @GetMapping("/staylike/{id}")
    public StayLikeDTO findById(@PathVariable int id){
        return stayLikeService.findById(id);
    }

}
