package com.example.planergram.controller;

import com.example.planergram.DTO.AttractionDTO;
import com.example.planergram.model.Attraction;
import com.example.planergram.model.Board;
import com.example.planergram.service.AttractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AttractionController {

    @Autowired
    private AttractionService attractionService;

    @GetMapping("/attraction")
    public List<AttractionDTO> findAll() {
        return attractionService.getAttractionList();
    }

    //보류
//    @GetMapping("/attraction/{attraction_address}")
//    public List<Attraction> findByAddress(){
//        return attractionService.findSeletedRegion();
//    }


    @DeleteMapping("/attraction/delete/{attractionId}")
    public void deleteById(@PathVariable Long attractionId) {
        attractionService.deleteAttraction(attractionId);
    }

    @PostMapping("/attraction/regist")
    public Attraction regist(@RequestBody AttractionDTO attractionDTO){
        return attractionService.createAttraction(attractionDTO);
    }

    @PostMapping("/attraction/edit/{attractionId}")
    public Attraction edit(@RequestBody AttractionDTO attractionDTO){
        return attractionService.editAttraction(attractionDTO);
    }
}
