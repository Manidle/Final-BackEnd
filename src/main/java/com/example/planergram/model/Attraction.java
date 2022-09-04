package com.example.planergram.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Attraction {

    @Id
    @Column(name="attraction_id",nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attractionId;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String addressDetail; //전체주소

    @Column(nullable = false)
    private String address; //시 군 구

    @Column(nullable = false)
    private Integer price;
}
