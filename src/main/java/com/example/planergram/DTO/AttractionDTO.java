package com.example.planergram.DTO;

import com.example.planergram.model.Attraction;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;

@Builder
@Data
public class AttractionDTO {
    private Long attractionId;
    private String attractionName;
    private String attractionAddress;
    private String attractionAddressDetail;
    private int attractionPrice;

    private AttractionDTO toAttractionDTO(Attraction attraction){
        return AttractionDTO.builder()
                .attractionId(attraction.getAttractionId())
                .attractionName(attraction.getAttractionName())
                .attractionAddress(attraction.getAttractionAddress())
                .attractionAddressDetail(attraction.getAttractionAddressDetail())
                .attractionPrice(attraction.getAttractionPrice())
                .build();
    }

    private Attraction showAttraction(AttractionDTO attractionDTO){
        return Attraction.builder()
                .attractionId(attractionDTO.getAttractionId())
                .attractionName(attractionDTO.getAttractionName())
                .attractionAddress(attractionDTO.getAttractionAddress())
                .attractionAddressDetail(attractionDTO.getAttractionAddressDetail())
                .attractionPrice(attractionDTO.getAttractionPrice())
                .build();
    }

}

