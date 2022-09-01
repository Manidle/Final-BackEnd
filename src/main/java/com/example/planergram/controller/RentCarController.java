package com.example.planergram.controller;

import com.example.planergram.DTO.RentCarDTO;
import com.example.planergram.service.RentCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RentCarController {

    @Autowired
    private RentCarService rentCarService;

    @PostMapping("/rentcar")
    public RentCarDTO signUp(@RequestBody RentCarDTO rentCarDTO){
        return rentCarService.signUp(rentCarDTO);
    }
}