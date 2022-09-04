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

    @Column(name = "attraction_name")
    private String attractionName;

    @Column(name = "attraction_address")
    private String attractionAddress; //시 군 구

    @Column(name = "attraction_address_detail")
    private String attractionAddressDetail; //전체주소

    @Column(name = "attraction_price")
    private Integer attractionPrice;
}
