package com.example.planergram.travelContents.repository;

import com.example.planergram.travelContents.model.Stay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StayRepository extends JpaRepository<Stay,Long> {
//    List<Stay> findByAddressAndDetailAddress(String address, String detailAddress);
//    List<Stay> findByAddress(String address);
}
