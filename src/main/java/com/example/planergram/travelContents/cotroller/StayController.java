package com.example.planergram.travelContents.cotroller;

import com.example.planergram.travelContents.DTO.StayDTO;
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
    public StayDTO findById(@PathVariable Long id){
        return stayService.findById(id);
    }

    @DeleteMapping("/stay/{id}")
    public void delete(@PathVariable Long id){
        stayService.delete(id);
    }

    @PatchMapping("/stay/{id}")
    public StayDTO update(@PathVariable Long id, @RequestBody StayDTO stayDTO){
        return stayService.update(id,stayDTO);
    }
}
