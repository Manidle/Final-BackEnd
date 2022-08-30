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
import java.util.Optional;

@Service
public class TrainService {

    private TrainRepository trainRepository;

    @Transactional(readOnly = true)
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

    @Transactional
    public void deleteTrain(Long trainId){
        Optional<Train> optTrain = trainRepository.findById(trainId);
        if(optTrain.isPresent()){
            Train train = optTrain.get();
            trainRepository.deleteById(trainId);
        }
    }

    public void createTrain(TrainDTO trainDTO){
        Train train = Train.builder()
                .trainId(trainDTO.getTrainId())
                .departureTime(trainDTO.getDepartureTime())
                .arriveTime(trainDTO.getArriveTime())
                .startPoint(trainDTO.getStartPoint())
                .endPoint(trainDTO.getEndPoint())
                .build();
        trainRepository.save(train);
    }

    public Train editTrain(TrainDTO trainDTO){
        try{
            Train train = trainRepository.findById(trainDTO.getTrainId()).get();
            train.setDepartureTime(trainDTO.getDepartureTime());
            train.setArriveTime(trainDTO.getArriveTime());
            train.setStartPoint(trainDTO.getStartPoint());
            train.setEndPoint(trainDTO.getEndPoint());
            return trainRepository.save(train);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //보류
//    public List<Train> findRegion(String endPoint) {
//        return trainRepository.findBySelected(endPoint);
//    }


}
