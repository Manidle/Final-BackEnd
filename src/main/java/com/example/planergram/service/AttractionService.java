package com.example.planergram.service;

import com.example.planergram.DTO.AttractionDTO;
import com.example.planergram.model.Attraction;
import com.example.planergram.repository.AttractionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AttractionService {

    private AttractionRepository attractionRepository;

    private AttractionDTO attractionDTO;




    //전체 조회
    @Transactional
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

    @Transactional
    public void deleteAttraction(Long attractionId){
        Optional<Attraction> optAttraction = attractionRepository.findById(attractionId);
        if(optAttraction.isPresent()){
            Attraction attraction = optAttraction.get();
            attractionRepository.deleteById(attractionId);
        }
    }


    public void createAttraction(AttractionDTO attractionDTO){
        Attraction attraction = Attraction.builder()
                .attractionId(attractionDTO.getAttractionId())
                .attractionName(attractionDTO.getAttractionName())
                .attractionAddress(attractionDTO.getAttractionAddress())
                .attractionAddressDetail(attractionDTO.getAttractionAddressDetail())
                .attractionPrice(attractionDTO.getAttractionPrice())
                .build();
        attractionRepository.save(attraction);
    }





//    @Transactional
//    public void editAttraction(Long attractionId, AttractionDTO attractionDTO){
//        Attraction attraction = attractionRepository.findById(attractionId)
//                .orElseThrow(RuntimeException::new);
//        Attraction.AttractionBuilder attractionBuilder = attractionDTO.
//    }



}
