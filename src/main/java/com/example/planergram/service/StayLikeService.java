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

    public String clickStayLike(Long userId, Long stayId) {
        User user = userRepository.getById(userId);
        Stay stay = stayRepository.getById(stayId);
        StayLike stayLike = stayLikeRepository.findByUserAndStay(user,stay);
        if (stayLike == null){
            return likeClick(user, stay);
        }
        return likeCancel(stay, stayLike);
    }

    private String likeClick(User user,Stay stay){
        stay.setLikeCount(stay.getLikeCount() + 1);
        stayRepository.save(stay);
        StayLike stayLike = StayLike.builder()
                .stay(stay)
                .user(user)
                .build();
        stayLikeRepository.save(stayLike);
        return "좋아요 클릭";
    }

    private String likeCancel(Stay stay,StayLike stayLike){
        stay.setLikeCount(stay.getLikeCount() - 1);
        stayRepository.save(stay);
        stayLikeRepository.delete(stayLike);
        return "좋아요 취소";
    }

    public StayLikeDTO findById(Long id){
        StayLike stayLike = stayLikeRepository.getById(id);
        return makeStayLikeDTO(stayLike);
    }

    public List<StayLikeDTO> findByUser(Long userId){
        User user = userRepository.getById(userId);
        List<StayLike> stayLikeList = stayLikeRepository.findByUser(user);
        return makeStayLikeDTOList(stayLikeList);
    }
    public List<StayLikeDTO> findByStay(Long stayId){
        Stay stay = stayRepository.getById(stayId);
        List<StayLike> stayLikeList = stayLikeRepository.findByStay(stay);
        return makeStayLikeDTOList(stayLikeList);
    }

    private StayLikeDTO makeStayLikeDTO(StayLike stayLike){
        return StayLikeDTO.builder()
                .id(stayLike.getId())
                .userId(stayLike.getUser().getUserId())
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