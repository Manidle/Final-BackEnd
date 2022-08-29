package com.example.planergram.repository;
import com.example.planergram.model.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainRepository extends JpaRepository<Train, Long> {
    @Query("from Train where endPoint= :endPoint")
    List<Train> findBySelected(@Param("endPoint") String endPoint);
}
