package com.example.planergram.travelContents.repository;

import com.example.planergram.travelContents.model.Stay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StayRepository extends JpaRepository<Stay,Long> {
    List<Stay> findTop5ByOrderByLikeCountDesc();


    @Query(value = "SELECT * FROM Stay WHERE NAME LIKE %:search% OR address LIKE %:search%",nativeQuery = true)
    List<Stay> findByNameLikeOrAddressLike(@Param("search") String search);
}
