package com.example.planergram.model;


import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@Entity
public class Attraction {

    @Id
    @Column(name="attraction_id",nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int attractionId;

    private String attractionName;

    private String attractionAddress; //시 군 구

    private String attractionAddressDetail; //전체주소

    private int attractionPrice;

}
