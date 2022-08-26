package com.example.planergram.service;

import com.example.planergram.model.Attraction;
import com.example.planergram.repository.AttractionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttractionService {

    private AttractionRepository attractionRepository;

    //전체 조회
    public List<Attraction> findAll(){
        return attractionRepository.findAll();
    }

    public List<Attraction> findSeletedRegion(){
        return attractionRepository.findByAttractionAddress();
    }

}
