package com.example.planergram.controller;

import com.example.planergram.DTO.StayDTO;
import com.example.planergram.service.StayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StayController {

    @Autowired
    private StayService stayService;

    @PostMapping("/stay")
    public StayDTO signUp(@RequestBody StayDTO stayDTO){
        return stayService.signUp(stayDTO);
    }

}
