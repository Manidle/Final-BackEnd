package com.example.planergram.userLike.service;

import com.example.planergram.userLike.DTO.AttractionLikeDTO;
import com.example.planergram.travelContents.model.Attraction;
import com.example.planergram.userLike.model.AttractionLike;
import com.example.planergram.user.model.User;
import com.example.planergram.userLike.repository.AttractionLikeRepository;
import com.example.planergram.travelContents.repository.AttractionRepository;
import com.example.planergram.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class AttractionLikeService {
    @Autowired
    private AttractionLikeRepository attractionLikeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AttractionRepository attractionRepository;

    public String clickAttractionLike(Long userId, Long attractionId) {
        User user = userRepository.getById(userId);
        Attraction attraction = attractionRepository.getById(attractionId);
        log.info("attractionLike : click 이후 user, attraction");
        AttractionLike attractionLike = attractionLikeRepository.findByUserAndAttraction(user, attraction);
        if (attractionLike == null) {
            log.info("attractionLike : 좋아요 클릭");
            return likeClick(user, attraction);
        }
        log.info("attractionLike : 좋아요 취소");
        return likeCancel(attraction, attractionLike);
    }

    private String likeClick(User user, Attraction attraction) {
        attraction.setLikeCount(attraction.getLikeCount() + 1);
        attractionRepository.save(attraction);
        AttractionLike attractionLike = AttractionLike.builder()
                .attraction(attraction)
                .user(user)
                .build();
        attractionLikeRepository.save(attractionLike);
        return "좋아요 클릭";
    }

    private String likeCancel(Attraction attraction, AttractionLike attractionLike) {
        attraction.setLikeCount(attraction.getLikeCount() - 1);
        attractionRepository.save(attraction);
        attractionLikeRepository.delete(attractionLike);
        return "좋아요 취소";
    }

    public List<AttractionLikeDTO> findByUser(Long userId) {
        User user = userRepository.getById(userId);
        List<AttractionLike> attractionLikeList = attractionLikeRepository.findByUser(user);
        return makeAttractionLikeDTOList(attractionLikeList);
    }

    public List<AttractionLikeDTO> findByAttraction(Long attractionId) {
        Attraction attraction = attractionRepository.getById(attractionId);
        List<AttractionLike> attractionLikeList = attractionLikeRepository.findByAttraction(attraction);
        return makeAttractionLikeDTOList(attractionLikeList);
    }

    public AttractionLikeDTO findById(Long id) {
        AttractionLike attractionLike = attractionLikeRepository.getById(id);
        return makeAttractionLikeDTO(attractionLike);
    }

    private List<AttractionLikeDTO> makeAttractionLikeDTOList(List<AttractionLike> attractionLikeList) {
        List<AttractionLikeDTO> attractionLikeDTOList = new ArrayList<>();
        for (AttractionLike attractionLike : attractionLikeList) {
            attractionLikeDTOList.add(makeAttractionLikeDTO(attractionLike));
        }
        return attractionLikeDTOList;
    }

    private AttractionLikeDTO makeAttractionLikeDTO(AttractionLike attractionLike) {
        return AttractionLikeDTO.builder()
                .attractionLikeId(attractionLike.getAttractionLikeId())
                .attractionId(attractionLike.getAttraction().getAttractionId())
                .userId(attractionLike.getUser().getUserId())
                .build();
    }
}
