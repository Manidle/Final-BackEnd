package com.example.planergram.travelContents.repository;

import com.example.planergram.travelContents.model.Attraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttractionRepository extends JpaRepository<Attraction, Long> {
    List<Attraction> findByAddressAndDetailAddress(String address, String detailAddress);
    List<Attraction> findByAddress(String address);
}
