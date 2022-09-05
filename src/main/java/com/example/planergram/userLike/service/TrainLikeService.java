package com.example.planergram.userLike.service;

import com.example.planergram.userLike.DTO.TrainLikeDTO;
import com.example.planergram.travelContents.model.Train;
import com.example.planergram.userLike.model.TrainLike;
import com.example.planergram.user.model.User;
import com.example.planergram.userLike.repository.TrainLikeRepository;
import com.example.planergram.travelContents.repository.TrainRepository;
import com.example.planergram.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<TrainLikeDTO> findByUser(Long userId){
        User user = userRepository.getById(userId);
        List<TrainLike> trainLikeList = trainLikeRepository.findByUser(user);
        return makeTrainLikeDTOList(trainLikeList);
    }

    public List<TrainLikeDTO> findByStay(Long trainId){
        Train train = trainRepository.getById(trainId);
        List<TrainLike> trainLikeList = trainLikeRepository.findByTrain(train);
        return makeTrainLikeDTOList(trainLikeList);
    }

    public TrainLikeDTO findById(Long id){
        TrainLike trainLike = trainLikeRepository.getById(id);
        return makeTrainLikeDTO(trainLike);
    }

    private TrainLikeDTO makeTrainLikeDTO(TrainLike trainLike){
        return TrainLikeDTO.builder()
                .trainLikeId(trainLike.getTrainLikeId())
                .trainId(trainLike.getTrain().getTrainId())
                .userId(trainLike.getUser().getUserId())
                .build();
    }

    private List<TrainLikeDTO> makeTrainLikeDTOList(List<TrainLike> trainLikeList){
        List<TrainLikeDTO> trainLikeDTOList = new ArrayList<>();
        for(TrainLike trainLike:trainLikeList){
            trainLikeDTOList.add(makeTrainLikeDTO(trainLike));
        }
        return trainLikeDTOList;
    }

}