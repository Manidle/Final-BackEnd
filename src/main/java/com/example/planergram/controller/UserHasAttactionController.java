package com.example.planergram.controller;

import com.example.planergram.model.UserHasAttraction;
import com.example.planergram.service.UserHasAttractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserHasAttactionController {

    @Autowired
    private UserHasAttractionService userHasAttractionService;

    @PutMapping("/myattraction/{user_id}")
    public List<UserHasAttraction> searchUser(int userId){
        return userHasAttractionService.findByUser(userId);
    }

    @PutMapping("/myattraction/{user_id}/{attraction_id}")
    public List<UserHasAttraction> searchAttraction(int attractionId){
        return userHasAttractionService.findByAttraction(attractionId);
    }
}
