package com.example.planergram.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Train {

    @Id
    @Column(name="train_id",nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trainId;

    @Column(name = "departure_time")
    private LocalDateTime departureTime;

    @Column(name = "arrive_time")
    private LocalDateTime arriveTime;

    @Column(name = "start_point")
    private String startPoint;

    @Column(name = "end_point")
    private String endPoint;

    @Column(name = "train_price")
    private int trainPrice;


}
