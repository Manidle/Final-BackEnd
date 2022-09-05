package com.example.planergram.travelContents.DTO;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrainDTO {
    private Long trainId;
    private LocalDateTime departureTime;
    private LocalDateTime arriveTime;
    private String startPoint;
    private String endPoint;
    private int trainPrice;
}
