package com.example.planergram.travelContents.service;

import com.example.planergram.travelContents.DTO.TrainDTO;
import com.example.planergram.travelContents.model.Train;
import com.example.planergram.travelContents.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainService {

    @Autowired
    private TrainRepository trainRepository;

    public TrainDTO signUp(TrainDTO trainDTO) {
        Train train = makeTrain(trainDTO);
        train = trainRepository.save(train);
        return makeTrainDTO(train);
    }

    public List<TrainDTO> findAll() {
        List<Train> trainList = trainRepository.findAll();
        List<TrainDTO> trainDTOList = new ArrayList<>();
        for (Train train: trainList) {
            trainDTOList.add(makeTrainDTO(train));
        }
        return trainDTOList;
    }

    public List<TrainDTO> findTop5ByOrderByLikeCountDesc() {
        List<Train> trainList = trainRepository.findTop5ByOrderByLikeCountDesc();
        List<TrainDTO> trainDTOList = new ArrayList<>();
        for (Train train: trainList) {
            trainDTOList.add(makeTrainDTO(train));
        }
        return trainDTOList;
    }

    public List<TrainDTO> findByStartPointAndEndPoint(String startPoint, String endPoint) {
        List<Train> trainList = trainRepository.findByStartPointAndEndPoint(startPoint,endPoint);
        List<TrainDTO> trainDTOList = new ArrayList<>();
        for (Train train: trainList) {
            trainDTOList.add(makeTrainDTO(train));
        }
        return trainDTOList;
    }

    public TrainDTO findById(Long id) {
        Train train = trainRepository.getById(id);
        return makeTrainDTO(train);
    }

    public List<TrainDTO> delete(Long id) {
        Train train = trainRepository.getById(id);
        trainRepository.delete(train);
        return findAll();
    }

    public TrainDTO update(Long id, TrainDTO trainDTO) {
        Train train = trainRepository.getById(id);
        train.setDepartureTime(trainDTO.getDepartureTime());
        train.setArriveTime(trainDTO.getArriveTime());
        train.setStartPoint(trainDTO.getStartPoint());
        train.setEndPoint(trainDTO.getEndPoint());
        train.setTrainPrice(trainDTO.getTrainPrice());
        train = trainRepository.save(train);
        return makeTrainDTO(train);
    }

    private Train makeTrain(TrainDTO trainDTO){
        return Train.builder()
                .trainId(trainDTO.getTrainId())
                .departureTime(trainDTO.getDepartureTime())
                .arriveTime(trainDTO.getArriveTime())
                .startPoint(trainDTO.getStartPoint())
                .endPoint(trainDTO.getEndPoint())
                .trainPrice(trainDTO.getTrainPrice())
                .likeCount(trainDTO.getLikeCount())
                .build();
    }

    private TrainDTO makeTrainDTO(Train train){
        return TrainDTO.builder()
                .trainId(train.getTrainId())
                .departureTime(train.getDepartureTime())
                .arriveTime(train.getArriveTime())
                .startPoint(train.getStartPoint())
                .endPoint(train.getEndPoint())
                .trainPrice(train.getTrainPrice())
                .likeCount(train.getLikeCount())
                .build();
    }
}