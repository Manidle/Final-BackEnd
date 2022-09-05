package com.example.planergram.service;

import com.example.planergram.travelContents.DTO.AttractionDTO;
import com.example.planergram.travelContents.model.Attraction;
import com.example.planergram.travelContents.repository.AttractionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AttractionService {

    @Autowired
    private AttractionRepository attractionRepository;

    public AttractionDTO signUp(AttractionDTO attractionDTO) {
        Attraction attraction = makeAttraction(attractionDTO);
        attraction = attractionRepository.save(attraction);
        return makeAttractionDTO(attraction);
    }

    public List<AttractionDTO> findAll() {
        List<Attraction> attractionList = attractionRepository.findAll();
        List<AttractionDTO> attractionDTOList = new ArrayList<>();
        for (Attraction attraction: attractionList) {
            attractionDTOList.add(makeAttractionDTO(attraction));
        }
        return attractionDTOList;
    }

    public AttractionDTO findById(Long id) {
        Attraction attraction = attractionRepository.getById(id);
        return makeAttractionDTO(attraction);
    }


    public void delete(Long id) {
        Attraction attraction = attractionRepository.getById(id);
        attractionRepository.delete(attraction);
    }

    public AttractionDTO update(Long id, AttractionDTO attractionDTO) {
        Attraction attraction = attractionRepository.getById(id);
        attraction.setName(attractionDTO.getName());
        attraction.setAddressDetail(attractionDTO.getAddressDetail());
        attraction.setAddress(attractionDTO.getAddress());
        attraction.setLikeCount(attraction.getLikeCount());
        attraction.setPrice(attractionDTO.getPrice());
        return makeAttractionDTO(attraction);
    }

    private Attraction makeAttraction(AttractionDTO attractionDTO){
        return Attraction.builder()
                .attractionId(attractionDTO.getAttractionId())
                .name(attractionDTO.getName())
                .addressDetail(attractionDTO.getAddressDetail())
                .address(attractionDTO.getAddress())
                .likeCount(attractionDTO.getLikeCount())
                .price(attractionDTO.getPrice())
                .build();
    }

    private AttractionDTO makeAttractionDTO(Attraction attraction){
          return AttractionDTO.builder()
                  .attractionId(attraction.getAttractionId())
                  .name(attraction.getName())
                  .likeCount(attraction.getLikeCount())
                  .addressDetail(attraction.getAddressDetail())
                  .address(attraction.getAddress())
                  .price(attraction.getPrice())
                  .build();
    }
}
