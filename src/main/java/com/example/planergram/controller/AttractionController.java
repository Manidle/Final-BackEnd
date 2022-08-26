package com.example.planergram.controller;

import com.example.planergram.model.Attraction;
import com.example.planergram.model.Board;
import com.example.planergram.service.AttractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AttractionController {

    @Autowired
    private AttractionService attractionService;

    @GetMapping("/attraction")
    public List<Attraction> findAll() {
        return attractionService.findAll();
    }

    @GetMapping("/attraction")
    public List<Attraction> findByAddress(){
        return attractionService.findSeletedRegion();
    }


}
