package com.example.planergram.controller;

import com.example.planergram.DTO.RentCarDTO;
import com.example.planergram.DTO.StayDTO;
import com.example.planergram.service.RentCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RentCarController {

    @Autowired
    private RentCarService rentCarService;

    @PostMapping("/rentcar")
    public RentCarDTO signUp(@RequestBody RentCarDTO rentCarDTO){
        return rentCarService.signUp(rentCarDTO);
    }

    @GetMapping("/rentcar")
    public List<RentCarDTO> findAll(){
        return rentCarService.findAll();
    }
}