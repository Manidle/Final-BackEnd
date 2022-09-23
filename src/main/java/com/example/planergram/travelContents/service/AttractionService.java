package com.example.planergram.travelContents.service;

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

    public List<AttractionDTO> findTop5ByOrderByLikeCountDesc() {
        List<Attraction> attractionList = attractionRepository.findTop5ByOrderByLikeCountDesc();
        List<AttractionDTO> attractionDTOList = new ArrayList<>();
        for (Attraction attraction: attractionList) {
            attractionDTOList.add(makeAttractionDTO(attraction));
        }
        return attractionDTOList;
    }

    public List<AttractionDTO> findByNameLikeOrAddressLike(String search) {
        List<Attraction> attractionList = attractionRepository.findByNameLikeOrAddressLike(search);
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


    public List<AttractionDTO> delete(Long id) {
        Attraction attraction = attractionRepository.getById(id);
        attractionRepository.delete(attraction);
        return findAll();
    }

    public AttractionDTO update(Long id, AttractionDTO attractionDTO) {
        Attraction attraction = attractionRepository.getById(id);
        attraction.setName(attractionDTO.getName());
        attraction.setAddress(attractionDTO.getAddress());
        attraction.setDescription(attractionDTO.getDescription());
        attraction.setLikeCount(attraction.getLikeCount());
        attraction.setPrice(attractionDTO.getPrice());
        return makeAttractionDTO(attraction);
    }

    private Attraction makeAttraction(AttractionDTO attractionDTO){
        return Attraction.builder()
                .attractionId(attractionDTO.getAttractionId())
                .name(attractionDTO.getName())
                .address(attractionDTO.getAddress())
                .description(attractionDTO.getDescription())
                .likeCount(attractionDTO.getLikeCount())
                .price(attractionDTO.getPrice())
                .build();
    }

    private AttractionDTO makeAttractionDTO(Attraction attraction){
          return AttractionDTO.builder()
                  .attractionId(attraction.getAttractionId())
                  .name(attraction.getName())
                  .likeCount(attraction.getLikeCount())
                  .address(attraction.getAddress())
                  .description(attraction.getDescription())
                  .price(attraction.getPrice())
                  .build();
    }
}
