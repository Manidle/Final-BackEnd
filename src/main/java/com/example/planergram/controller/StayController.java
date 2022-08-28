package com.example.planergram.controller;

import com.example.planergram.DTO.StayDTO;
import com.example.planergram.service.StayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StayController {

    @Autowired
    private StayService stayService;

    @PostMapping("/stay")
    public StayDTO signUp(@RequestBody StayDTO stayDTO){
        return stayService.signUp(stayDTO);
    }


    @GetMapping("/stay")
    public List<StayDTO> findAll(){
        return stayService.findAll();
    }

    @GetMapping("/stay/{id}")
    public StayDTO findById(@PathVariable int id){
        return stayService.findById(id);
    }
}
