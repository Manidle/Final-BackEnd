package com.example.planergram.repository;

import com.example.planergram.model.Train;
import com.example.planergram.model.UserHasAttraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserHasAttractionRepository extends JpaRepository<UserHasAttraction, Long> {

//    List<UserHasAttraction> findByUser(@Param("userId") int userId);

//    List<UserHasAttraction> findByAttraction(@Param("attractionId") int attractionId);
}
