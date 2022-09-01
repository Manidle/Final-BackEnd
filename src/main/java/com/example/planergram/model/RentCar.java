package com.example.planergram.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class RentCar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rentCarId;

    @Column(nullable = false, length = 30)
    private String address;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name = "car_sort", nullable = false)
    private String carSort;

    @Column(name = "car_name", nullable = false)
    private String carName;
}