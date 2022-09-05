package com.example.planergram.travelContents.repository;

import com.example.planergram.travelContents.model.RentCar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentCarRepository extends JpaRepository<RentCar, Long> {
}