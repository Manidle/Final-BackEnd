package com.example.planergram.service;

import com.example.planergram.DTO.AttractionDTO;
import com.example.planergram.DTO.UserHasAttractionDTO;
import com.example.planergram.model.Attraction;
import com.example.planergram.model.User;
import com.example.planergram.model.UserHasAttraction;
import com.example.planergram.repository.UserHasAttractionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserHasAttractionService {

    private UserHasAttractionRepository userHasAttractionRepository;

//    public List<UserHasAttraction> findByUser(Long userId){
//        return userHasAttractionRepository.findByUser(userId);
//    }


//    public List<UserHasAttractionDTO> deleteAttraction(Long attractionId){
//    Optional<Attraction> optAttraction = attractionRepository.findById(attractionId);
//        if(optAttraction.isPresent()){
//        Attraction attraction = optAttraction.get();
//        attractionRepository.deleteById(attractionId);
//    }}

    @Transactional(readOnly = true)
    public List<UserHasAttractionDTO> getUserHasAttractionListByUserId(Long userId){
        Optional<UserHasAttraction> optUserHasAttractions = userHasAttractionRepository.findById(userId);
        List<UserHasAttraction> UserHasAttractions = userHasAttractionRepository.findAll();
        List<UserHasAttractionDTO> UserHasAttractionDtoList = new ArrayList<>();
        if(optUserHasAttractions.isPresent()){
            for(UserHasAttraction userHasAttraction : UserHasAttractions){
                UserHasAttractionDTO dto = UserHasAttractionDTO.builder()
                        .userId(userHasAttraction.getUserId())
                        .attractionId(userHasAttraction.getAttractionId())
                        .build();
                UserHasAttractionDtoList.add(dto);
            }
        }
        return UserHasAttractionDtoList;
    }

//    public List<UserHasAttraction> findByAttraction(Long attractionId){
//        return userHasAttractionRepository.findByAttraction(attractionId);
//    }

    @Transactional(readOnly = true)
    public List<UserHasAttractionDTO> getUserHasAttractionListByAttractionId(Long attractionId){
        Optional<UserHasAttraction> optUserHasAttractions = userHasAttractionRepository.findById(attractionId);
        List<UserHasAttraction> UserHasAttractions = userHasAttractionRepository.findAll();
        List<UserHasAttractionDTO> UserHasAttractionDtoList = new ArrayList<>();
        if(optUserHasAttractions.isPresent()){
            for(UserHasAttraction userHasAttraction : UserHasAttractions){
                UserHasAttractionDTO dto = UserHasAttractionDTO.builder()
                        .userId(userHasAttraction.getUserId())
                        .attractionId(userHasAttraction.getAttractionId())
                        .build();
                UserHasAttractionDtoList.add(dto);
            }
        }
        return UserHasAttractionDtoList;
    }
}
