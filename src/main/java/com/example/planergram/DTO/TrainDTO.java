package com.example.planergram.DTO;

import java.time.LocalDateTime;

public class TrainDTO {
    private Long trainId;
    private LocalDateTime departureTime;
    private LocalDateTime arriveTime;
    private String startPoint;
    private String endPoint;
    private int trainPrice;
}
