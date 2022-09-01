package com.example.planergram.service;

import com.example.planergram.DTO.AttractionDTO;
import com.example.planergram.model.Attraction;
import com.example.planergram.repository.AttractionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AttractionService {

    @Autowired
    private AttractionRepository attractionRepository;

    private AttractionDTO attractionDTO;

    private Attraction attraction;



    //전체 조회
    @Transactional(readOnly = true)
    public List<AttractionDTO> getAttractionList(){
        List<Attraction> Attractions = attractionRepository.findAll();
        List<AttractionDTO> AttractionDtoList = new ArrayList<>();

        for(Attraction attraction : Attractions){
            AttractionDTO dto = AttractionDTO.builder()
                    .attractionId(attraction.getAttractionId())
                    .attractionName(attraction.getAttractionName())
                    .attractionAddress(attraction.getAttractionAddress())
                    .attractionAddressDetail(attraction.getAttractionAddressDetail())
                    .attractionPrice(attraction.getAttractionPrice())
                    .build();
            AttractionDtoList.add(dto);
        }
        return AttractionDtoList;
    }





//    @Transactional
//    public void editAttraction(Long attractionId, AttractionDTO attractionDTO){
//        Attraction attraction = attractionRepository.findById(attractionId)
//                .orElseThrow(RuntimeException::new);
//        Attraction.AttractionBuilder attractionBuilder = attractionDTO.
//    }



}
