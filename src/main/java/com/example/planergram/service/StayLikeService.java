package com.example.planergram.service;

import com.example.planergram.DTO.StayLikeDTO;
import com.example.planergram.model.Stay;
import com.example.planergram.model.StayLike;
import com.example.planergram.model.User;
import com.example.planergram.repository.StayLikeRepository;
import com.example.planergram.repository.StayRepository;
import com.example.planergram.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StayLikeService {
    @Autowired
    private StayLikeRepository stayLikeRepository;

    @Autowired
    private StayRepository stayRepository;

    @Autowired
    private UserRepository userRepository;

    public String clickStayLike(int userId, int stayId) {
        User user = userRepository.getById(userId);
        Stay stay = stayRepository.getById(stayId);
        StayLike stayLike = stayLikeRepository.findByUserAndStay(user,stay);
        if (stayLike == null){
            stayLike = StayLike.builder()
                    .stay(stay)
                    .user(user)
                    .build();
            stayLikeRepository.save(stayLike);
            return "좋아요 클릭";
        }
        stayLikeRepository.delete(stayLike);
        return "좋아요 취소";
    }

    public StayLikeDTO findById(int id){
        StayLike stayLike = stayLikeRepository.getById(id);
        return makeStayLikeDTO(stayLike);
    }

    private StayLike makeStayLike(StayLikeDTO stayLikeDTO){
        User user = userRepository.getById(stayLikeDTO.getUserId());
        Stay stay = stayRepository.getById(stayLikeDTO.getStayId());
        return StayLike.builder()
                .user(user)
                .stay(stay)
                .build();
    }

    private StayLikeDTO makeStayLikeDTO(StayLike stayLike){
        return StayLikeDTO.builder()
                .id(stayLike.getId())
                .userId(stayLike.getUser().getId())
                .stayId(stayLike.getStay().getId())
                .build();
    }
}
