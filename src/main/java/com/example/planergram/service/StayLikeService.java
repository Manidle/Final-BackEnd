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

import java.util.ArrayList;
import java.util.List;

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
            return likeClick(user,stay);
        }
        return likeCancel(stayLike);
    }

    private String likeClick(User user,Stay stay){
        StayLike stayLike = StayLike.builder()
                .stay(stay)
                .user(user)
                .build();
        stayLikeRepository.save(stayLike);
        return "좋아요 클릭";
    }

    private String likeCancel(StayLike stayLike){
        stayLikeRepository.delete(stayLike);
        return "좋아요 취소";
    }

    public StayLikeDTO findById(int id){
        StayLike stayLike = stayLikeRepository.getById(id);
        return makeStayLikeDTO(stayLike);
    }

    public List<StayLikeDTO> findByUser(int userId){
        User user = userRepository.getById(userId);
        List<StayLike> stayLikeList = stayLikeRepository.findByUser(user);
        return makeStayLikeDTOList(stayLikeList);
    }
    public List<StayLikeDTO> findByStay(int stayId){
        Stay stay = stayRepository.getById(stayId);
        List<StayLike> stayLikeList = stayLikeRepository.findByStay(stay);
        return makeStayLikeDTOList(stayLikeList);
    }

    private StayLikeDTO makeStayLikeDTO(StayLike stayLike){
        return StayLikeDTO.builder()
                .id(stayLike.getId())
                .userId(stayLike.getUser().getId())
                .stayId(stayLike.getStay().getId())
                .build();
    }

    private List<StayLikeDTO> makeStayLikeDTOList(List<StayLike> stayLikeList){
        List<StayLikeDTO> stayLikeDTOList = new ArrayList<>();
        for(StayLike stayLike:stayLikeList){
            stayLikeDTOList.add(makeStayLikeDTO(stayLike));
        }
        return stayLikeDTOList;
    }
}
