package com.example.planergram.controller;

import com.example.planergram.DTO.UserHasAttractionDTO;
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

    @PutMapping("/myattraction/user/{user_id}")
    public List<UserHasAttractionDTO> searchByUser(Long userId){
        return userHasAttractionService.getUserHasAttractionListByUserId(userId);
    }

    @PutMapping("/myattraction/attraction/{attraction_id}")
    public List<UserHasAttractionDTO> searchByAttraction(Long attractionId){
        return userHasAttractionService.getUserHasAttractionListByAttractionId(attractionId);
    }
}
