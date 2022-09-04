package com.example.planergram.controller;

import com.example.planergram.DTO.AttractionDTO;
import com.example.planergram.service.AttractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/attraction")
@RestController
public class AttractionController {

    @Autowired
    private AttractionService attractionService;

    @PostMapping
    public AttractionDTO signUp(@RequestBody AttractionDTO attractionDTO){
        return attractionService.signUp(attractionDTO);
    }

    @GetMapping
    public List<AttractionDTO> findAll(){
        return attractionService.findAll();
    }

    @GetMapping("/{id}")
    public AttractionDTO findById(@PathVariable Long id){
        return attractionService.findById(id);
    }

    @PatchMapping("/{id}")
    public AttractionDTO update(@PathVariable Long id, @RequestBody AttractionDTO attractionDTO){
        return attractionService.update(id,attractionDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        attractionService.delete(id);
    }
}
