package com.example.planergram.userLike.service;

import com.example.planergram.user.model.User;
import com.example.planergram.user.repository.UserRepository;
import com.example.planergram.userLike.DTO.TrainLikeDTO;
import com.example.planergram.userLike.model.TrainLike;
import com.example.planergram.userLike.repository.TrainLikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainLikeService {

    @Autowired
    private TrainLikeRepository trainLikeRepository;

    @Autowired
    private UserRepository userRepository;

    public String clickTrainLike(TrainLikeDTO trainLikeDTO) {
        User user = userRepository.getById(trainLikeDTO.getUserId());
        int trainno = trainLikeDTO.getTrainno();
        TrainLike trainLike = trainLikeRepository.findByUserAndTrainno(user, trainno);
        if (trainLike == null) {
            return likeClick(user, trainLikeDTO);
        }
        return likeCancel(trainLike);
    }

    private String likeClick(User user, TrainLikeDTO trainLikeDTO) {
        TrainLike trainLike = TrainLike.builder()
                .user(user)
                .depplacename(trainLikeDTO.getDepplacename())
                .arrplacename(trainLikeDTO.getArrplacename())
                .depplandtime(trainLikeDTO.getDepplandtime())
                .arrplandtime(trainLikeDTO.getArrplandtime())
                .adultcharge(trainLikeDTO.getAdultcharge())
                .trainno(trainLikeDTO.getTrainno())
                .build();
        trainLikeRepository.save(trainLike);
        return "좋아요 클릭";
    }

    private String likeCancel(TrainLike trainLike) {
        trainLikeRepository.delete(trainLike);
        return "좋아요 취소";
    }

    public List<TrainLikeDTO> findByUser(Long userId) {
        User user = userRepository.getById(userId);
        System.out.println("유저레파지토리에서 userId=1에서 찾은 유저:" + user);
        List<TrainLike> trainLikeList = trainLikeRepository.findByUser(user);
        return makeTrainLikeDTOList(trainLikeList);
    }

    public TrainLikeDTO findById(Long id) {
        TrainLike trainLike = trainLikeRepository.getById(id);
        return makeTrainLikeDTO(trainLike);
    }

    private TrainLikeDTO makeTrainLikeDTO(TrainLike trainLike) {
        return TrainLikeDTO.builder()
                .trainLikeId(trainLike.getTrainLikeId())
                .userId(trainLike.getUser().getUserId())
                .depplacename(trainLike.getDepplacename())
                .arrplacename(trainLike.getArrplacename())
                .arrplandtime(trainLike.getArrplandtime())
                .depplandtime(trainLike.getDepplandtime())
                .adultcharge(trainLike.getAdultcharge())
                .trainno(trainLike.getTrainno())
                .build();
    }

    private TrainLike makeTrainLike(TrainLikeDTO trainLikeDTO) {
        return TrainLike.builder()
                .trainno(trainLikeDTO.getTrainno())
                .arrplacename(trainLikeDTO.getArrplacename())
                .depplacename(trainLikeDTO.getDepplacename())
                .build();
    }

    private List<TrainLikeDTO> makeTrainLikeDTOList(List<TrainLike> trainLikeList) {
        List<TrainLikeDTO> trainLikeDTOList = new ArrayList<>();
        for (TrainLike trainLike : trainLikeList) {
            trainLikeDTOList.add(makeTrainLikeDTO(trainLike));
        }
        return trainLikeDTOList;
    }
}