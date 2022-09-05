package com.example.planergram.userLike.service;

import com.example.planergram.userLike.DTO.RentCarLikeDTO;
import com.example.planergram.travelContents.model.RentCar;
import com.example.planergram.userLike.model.RentCarLike;
import com.example.planergram.user.model.User;
import com.example.planergram.userLike.repository.RentCarLikeRepository;
import com.example.planergram.travelContents.repository.RentCarRepository;
import com.example.planergram.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<RentCarLikeDTO> findByUser(Long userId){
        User user = userRepository.getById(userId);
        List<RentCarLike> rentCarLikeList = rentCarLikeRepository.findByUser(user);
        return makeRentCarLikeDTOList(rentCarLikeList);
    }

    public List<RentCarLikeDTO> findByRentCar(Long rentCarId){
        RentCar rentCar = rentCarRepository.getById(rentCarId);
        List<RentCarLike> rentCarLikeList = rentCarLikeRepository.findByRentCar(rentCar);
        return makeRentCarLikeDTOList(rentCarLikeList);
    }

    public RentCarLikeDTO findById(Long id){
        RentCarLike rentCarLike = rentCarLikeRepository.getById(id);
        return makeRentCarLikeDTO(rentCarLike);
    }

    private RentCarLikeDTO makeRentCarLikeDTO(RentCarLike rentCarLike){
        return RentCarLikeDTO.builder()
                .rentCarLikeId(rentCarLike.getRentCarLikeId())
                .userId(rentCarLike.getUser().getUserId())
                .rentCarId(rentCarLike.getRentCar().getRentCarId())
                .build();
    }

    private List<RentCarLikeDTO> makeRentCarLikeDTOList(List<RentCarLike> rentCarLikeList){
        List<RentCarLikeDTO> rentCarLikeDTOList = new ArrayList<>();
        for(RentCarLike rentCarLike:rentCarLikeList){
            rentCarLikeDTOList.add(makeRentCarLikeDTO(rentCarLike));
        }
        return rentCarLikeDTOList;
    }
}