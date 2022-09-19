package com.example.planergram.travelContents.repository;

import com.example.planergram.travelContents.model.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainRepository extends JpaRepository<Train, Long> {
    List<Train> findByStartPointAndEndPoint(String startPoint, String endPoint);
}
