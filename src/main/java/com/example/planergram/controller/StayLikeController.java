package com.example.planergram.controller;

import com.example.planergram.DTO.StayDTO;
import com.example.planergram.service.StayLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
