package com.example.planergram.controller;

import com.example.planergram.DTO.AttractionDTO;
import com.example.planergram.DTO.TrainDTO;
import com.example.planergram.model.Attraction;
import com.example.planergram.model.Train;
import com.example.planergram.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TrainController {

    @Autowired
    private TrainService trainService;

    @GetMapping("/train")
    public List<TrainDTO> findAll() {
        return trainService.getTrainList();
    }

    @DeleteMapping("/train/delete/{train_id}")
    public void deleteById(Long trainId) {
        trainService.deleteTrain(trainId);
    }

    @PostMapping("/train/regist")
    public void regist(TrainDTO trainDTO){
        trainService.createTrain(trainDTO);
    }

    @PostMapping("/train/edit/{train_id}")
    public Train edit(TrainDTO trainDTO){
        return trainService.editTrain(trainDTO);
    }

}
