package com.example.planergram.controller;

import com.example.planergram.DTO.RentCarDTO;
import com.example.planergram.service.RentCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rentcar")
public class RentCarController {

    @Autowired
    private RentCarService rentCarService;

    @PostMapping
    public RentCarDTO signUp(@RequestBody RentCarDTO rentCarDTO){
        return rentCarService.signUp(rentCarDTO);
    }

    @GetMapping
    public List<RentCarDTO> findAll(){
        return rentCarService.findAll();
    }

    @GetMapping("/{id}")
    public RentCarDTO findById(@PathVariable Long id){
        return rentCarService.findById(id);
    }

    @PatchMapping("/{id}")
    public RentCarDTO update(@PathVariable Long id, @RequestBody RentCarDTO rentCarDTO){
        return rentCarService.update(id,rentCarDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        rentCarService.delete(id);
    }







}