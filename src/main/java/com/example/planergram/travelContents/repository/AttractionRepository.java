package com.example.planergram.travelContents.repository;

import com.example.planergram.travelContents.model.Attraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AttractionRepository extends JpaRepository<Attraction, Long> {
    List<Attraction> findByAddressAndDetailAddress(String address, String detailAddress);
    List<Attraction> findByAddress(String address);
    List<Attraction> findByNameLike(String name);
    List<Attraction> findTop5ByOrderByLikeCountDesc();

    @Query(value = "SELECT * FROM attraction WHERE NAME LIKE %:search% OR detailAddress LIKE %:search% OR address LIKE %:search%",nativeQuery = true)
    List<Attraction> findByNameOrDetailAddressLike(String search);
}
