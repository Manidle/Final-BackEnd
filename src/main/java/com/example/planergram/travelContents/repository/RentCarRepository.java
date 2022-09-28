package com.example.planergram.travelContents.repository;

import com.example.planergram.travelContents.model.RentCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RentCarRepository extends JpaRepository<RentCar, Long> {
    List<RentCar> findTop5ByOrderByLikeCountDesc();

    @Query(value = "SELECT * FROM RentCar WHERE company_Name LIKE %:search% OR address LIKE %:search% OR car_Name LIKE %:search%", nativeQuery = true)
    List<RentCar> findByNameLikeOrAddressLikeOrCompanyName(@Param("search") String search);
}