package com.example.planergram.DTO;

import com.example.planergram.model.Train;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class TrainDTO {
    private Long trainId;
    private LocalDateTime departureTime;
    private LocalDateTime arriveTime;
    private String startPoint;
    private String endPoint;
    private int trainPrice;

    private TrainDTO toTrainDTO(Train train){
        return TrainDTO.builder()
                .trainId(train.getTrainId())
                .departureTime(train.getDepartureTime())
                .arriveTime(train.getArriveTime())
                .startPoint(train.getStartPoint())
                .endPoint(train.getEndPoint())
                .trainPrice(train.getTrainPrice())
                .build();
    }

    private Train toTrain(TrainDTO trainDTO){
        return  Train.builder()
                .trainId(trainDTO.getTrainId())
                .departureTime(trainDTO.getDepartureTime())
                .arriveTime(trainDTO.getArriveTime())
                .startPoint(trainDTO.getStartPoint())
                .endPoint(trainDTO.getEndPoint())
                .trainPrice(trainDTO.getTrainPrice())
                .build();
    }
}
