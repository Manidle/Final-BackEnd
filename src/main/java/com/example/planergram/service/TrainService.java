package com.example.planergram.service;

import com.example.planergram.model.Attraction;
import com.example.planergram.model.Train;
import com.example.planergram.repository.TrainRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainService {

    private TrainRepository trainRepository;

    public List<Train> findAll(){
        return trainRepository.findAll();
    }


    public List<Train> findRegion(String endPoint) {
        return trainRepository.findBySelected(endPoint);
    }


}
