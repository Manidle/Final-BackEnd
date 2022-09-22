package com.example.planergram.travelContents.repository;

import com.example.planergram.travelContents.model.Train;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainRepository extends JpaRepository<Train, Long> {
    List<Train> findByStartPointLikeAndEndPointLike(String startPoint, String endPoint);
    List<Train> findTop5ByOrderByLikeCountDesc();
}
