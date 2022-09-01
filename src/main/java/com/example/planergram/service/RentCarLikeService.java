package com.example.planergram.service;

import com.example.planergram.model.*;
import com.example.planergram.repository.RentCarLikeRepository;
import com.example.planergram.repository.RentCarRepository;
import com.example.planergram.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentCarLikeService {

    @Autowired
    private RentCarRepository rentCarRepository;

    @Autowired
    private RentCarLikeRepository rentCarLikeRepository;

    @Autowired
    private UserRepository userRepository;

    public String clickRentCarLike(Long userId, Long rentCarId) {
        User user = userRepository.getById(userId);
        RentCar rentCar  = rentCarRepository.getById(rentCarId);
        RentCarLike rentCarLike = rentCarLikeRepository.findByUserAndRentCar(user,rentCar);
        if (rentCarLike == null){
            return likeClick(user, rentCar);
        }
        return likeCancel(rentCar, rentCarLike);
    }

    private String likeClick(User user, RentCar rentCar){
        rentCar.setLikeCount(rentCar.getLikeCount() + 1);
        rentCarRepository.save(rentCar);
        RentCarLike rentCarLike = RentCarLike.builder()
                .rentCar(rentCar)
                .user(user)
                .build();
        rentCarLikeRepository.save(rentCarLike);
        return "좋아요 클릭";
    }

    private String likeCancel(RentCar rentCar,RentCarLike rentCarLike){
        rentCar.setLikeCount(rentCar.getLikeCount() - 1);
        rentCarRepository.save(rentCar);
        rentCarLikeRepository.delete(rentCarLike);
        return "좋아요 취소";
    }
}