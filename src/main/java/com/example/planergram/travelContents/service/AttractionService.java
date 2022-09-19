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

    public List<AttractionDTO> findByAddressAndDetailAddress(String address,String detailAddress) {
        List<Attraction> attractionList = attractionRepository.findByAddressAndDetailAddress(address,detailAddress);
        List<AttractionDTO> attractionDTOList = new ArrayList<>();
        for (Attraction attraction: attractionList) {
            attractionDTOList.add(makeAttractionDTO(attraction));
        }
        return attractionDTOList;
    }

    public List<AttractionDTO> findByAddress(String address) {
        List<Attraction> attractionList = attractionRepository.findByAddress(address);
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
        attraction.setDetailAddress(attraction.getDetailAddress());
        attraction.setAddress(attractionDTO.getAddress());
        attraction.setLikeCount(attraction.getLikeCount());
        attraction.setPrice(attractionDTO.getPrice());
        return makeAttractionDTO(attraction);
    }

    private Attraction makeAttraction(AttractionDTO attractionDTO){
        return Attraction.builder()
                .attractionId(attractionDTO.getAttractionId())
                .name(attractionDTO.getName())
                .detailAddress(attractionDTO.getDetailAddress())
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
                  .detailAddress(attraction.getDetailAddress())
                  .address(attraction.getAddress())
                  .price(attraction.getPrice())
                  .build();
    }
}
