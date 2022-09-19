package com.example.planergram.travelContents.repository;

import com.example.planergram.travelContents.model.RentCar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentCarRepository extends JpaRepository<RentCar, Long> {
    List<RentCar> findByAddressAndDetailAddress(String address, String detailAddress);
    List<RentCar> findByAddress(String address);
    List<RentCar> findByCarNameLike(String carName);
}