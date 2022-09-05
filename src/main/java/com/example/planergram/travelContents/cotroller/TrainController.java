package com.example.planergram.travelContents.cotroller;

import com.example.planergram.DTO.TrainDTO;
import com.example.planergram.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/train")
public class TrainController {

    @Autowired
    private TrainService trainService;

    @PostMapping
    public TrainDTO signUp(@RequestBody TrainDTO trainDTO){
        return trainService.signUp(trainDTO);
    }

    @GetMapping
    public List<TrainDTO> findAll() {
        return trainService.findAll();
    }

    @GetMapping("/{id}")
    public TrainDTO findById(@PathVariable Long id){
        return trainService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        trainService.delete(id);
    }

    @PatchMapping("/{id}")
    public TrainDTO update(@PathVariable Long id, @RequestBody TrainDTO trainDTO){
        return trainService.update(id,trainDTO);
    }

}
