package com.example.planergram.repository;

import com.example.planergram.model.Train;
import com.example.planergram.model.TrainLike;
import com.example.planergram.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainLikeRepository extends JpaRepository<TrainLike,Long> {
    TrainLike findByUserAndTrain(User user, Train train);
}
