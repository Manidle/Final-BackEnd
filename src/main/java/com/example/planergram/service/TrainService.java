package com.example.planergram.service;

import com.example.planergram.DTO.AttractionDTO;
import com.example.planergram.DTO.TrainDTO;
import com.example.planergram.model.Attraction;
import com.example.planergram.model.Train;
import com.example.planergram.repository.TrainRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainService {

    private TrainRepository trainRepository;

    @Transactional
    public List<TrainDTO> getTrainList(){
        List<Train> Trains = trainRepository.findAll();
        List<TrainDTO> TrainDTOList = new ArrayList<>();

        for(Train train : Trains){
            TrainDTO dto = TrainDTO.builder()
                    .trainId(train.getTrainId())
                    .departureTime(train.getDepartureTime())
                    .arriveTime(train.getArriveTime())
                    .startPoint(train.getStartPoint())
                    .endPoint(train.getEndPoint())
                    .build();
            TrainDTOList.add(dto);
        }
        return TrainDTOList;
    }

    //보류
//    public List<Train> findRegion(String endPoint) {
//        return trainRepository.findBySelected(endPoint);
//    }


}
