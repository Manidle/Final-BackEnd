package com.example.planergram.repository;

import com.example.planergram.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainLikeRepository extends JpaRepository<TrainLike,Long> {
    TrainLike findByUserAndTrain(User user, Train train);
    List<TrainLike> findByUser(User user);
    List<TrainLike> findByTrain(Train train);
}
