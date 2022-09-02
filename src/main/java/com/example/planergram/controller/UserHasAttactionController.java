package com.example.planergram.controller;

import com.example.planergram.DTO.UserHasAttractionDTO;
import com.example.planergram.model.UserHasAttraction;
import com.example.planergram.service.UserHasAttractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserHasAttactionController {

    @Autowired
    private UserHasAttractionService userHasAttractionService;

    @GetMapping("/myattraction/user/{userId}")
    public List<UserHasAttractionDTO> searchByUser(@PathVariable Long userId){
        return userHasAttractionService.getUserHasAttractionListByUserId(userId);
    }

    @GetMapping("/myattraction/attraction/{userHasAttractionId}")
    public List<UserHasAttractionDTO> searchByAttraction(@PathVariable Long attractionId){
        return userHasAttractionService.getUserHasAttractionListByAttractionId(attractionId);
    }
}
