package com.example.planergram.travelContents.repository;

import com.example.planergram.travelContents.model.Attraction;
import com.example.planergram.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AttractionRepository extends JpaRepository<Attraction, Long> {
    List<Attraction> findTop5ByOrderByLikeCountDesc();

    @Query(value = "SELECT * FROM attraction WHERE NAME LIKE %:search% OR address LIKE %:search%", nativeQuery = true)
    List<Attraction> findByNameLikeOrAddressLike(@Param("search") String search);

}
