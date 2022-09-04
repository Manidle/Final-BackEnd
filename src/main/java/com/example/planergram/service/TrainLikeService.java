package com.example.planergram.service;

import com.example.planergram.model.*;
import com.example.planergram.repository.TrainLikeRepository;
import com.example.planergram.repository.TrainRepository;
import com.example.planergram.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainLikeService {

    @Autowired
    private TrainLikeRepository trainLikeRepository;

    @Autowired
    private TrainRepository trainRepository;

    @Autowired
    private UserRepository userRepository;

    public String clickTrainLike(Long userId, Long trainId) {
        User user = userRepository.getById(userId);
        Train train = trainRepository.getById(trainId);
        TrainLike trainLike = trainLikeRepository.findByUserAndTrain(user,train);
        if (trainLike == null){
            return likeClick(user, train);
        }
        return likeCancel(train, trainLike);
    }

    private String likeClick(User user,Train train){
        train.setLikeCount(train.getLikeCount() + 1);
        trainRepository.save(train);
        TrainLike trainLike = TrainLike.builder()
                .train(train)
                .user(user)
                .build();
        trainLikeRepository.save(trainLike);
        return "좋아요 클릭";
    }

    private String likeCancel(Train train,TrainLike trainLike){
        train.setLikeCount(train.getLikeCount() - 1);
        trainRepository.save(train);
        trainLikeRepository.delete(trainLike);
        return "좋아요 취소";
    }
}