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

    @Column(name = "attraction_name")
    private String attractionName;

    @Column(name = "attraction_address")
    private String attractionAddress; //시 군 구

    @Column(name = "attraction_address_detail")
    private String attractionAddressDetail; //전체주소

    @Column(name = "attraction_price")
    private int attractionPrice;

}
