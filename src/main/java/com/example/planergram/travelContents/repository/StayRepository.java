package com.example.planergram.travelContents.repository;

import com.example.planergram.travelContents.model.Stay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StayRepository extends JpaRepository<Stay,Long> {
    List<Stay> findByAddressAndDetailAddress(String address, String detailAddress);
    List<Stay> findByAddress(String address);
    List<Stay> findByNameLike(String name);

    @Query(value = "SELECT * FROM Stay WHERE NAME LIKE %:search% OR detailAddress LIKE %:search% OR address LIKE %:search%",nativeQuery = true)
    List<Stay> findByNameOrDetailAddressLike(String search);
}
