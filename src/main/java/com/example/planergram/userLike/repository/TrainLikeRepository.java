package com.example.planergram.userLike.repository;

import com.example.planergram.travelContents.model.Train;
import com.example.planergram.user.model.User;
import com.example.planergram.userLike.model.TrainLike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainLikeRepository extends JpaRepository<TrainLike,Long> {
//    TrainLike findByUserAndTrain(User user, Train train);
    TrainLike findByUserAndTrainno(User user, int trainno);
    List<TrainLike> findByUser(User user);
    List<TrainLike> findByTrain(Train train);
}
