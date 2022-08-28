package com.example.planergram.service;

import com.example.planergram.model.UserHasAttraction;
import com.example.planergram.repository.UserHasAttractionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserHasAttractionService {

    private UserHasAttractionRepository userHasAttractionRepository;

    public List<UserHasAttraction> findByUser(int userId){
        return userHasAttractionRepository.findByUser(userId);
    }

    public List<UserHasAttraction> findByAttraction(int attractionId){
        return userHasAttractionRepository.findByAttraction(attractionId);
    }
}
