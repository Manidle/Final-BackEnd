package com.example.planergram.DTO;

import com.example.planergram.model.Attraction;
import lombok.*;

import javax.persistence.Entity;


@Data
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AttractionDTO {
    private Long attractionId;
    private String attractionName;
    private String attractionAddress;
    private String attractionAddressDetail;
    private Integer attractionPrice;

    private AttractionDTO toAttractionDTO(Attraction attraction){
        return AttractionDTO.builder()
                .attractionId(attraction.getAttractionId())
                .attractionName(attraction.getAttractionName())
                .attractionAddress(attraction.getAttractionAddress())
                .attractionAddressDetail(attraction.getAttractionAddressDetail())
                .attractionPrice(attraction.getAttractionPrice())
                .build();
    }

    private Attraction toAttraction(AttractionDTO attractionDTO){
        return Attraction.builder()
                .attractionId(attractionDTO.getAttractionId())
                .attractionName(attractionDTO.getAttractionName())
                .attractionAddress(attractionDTO.getAttractionAddress())
                .attractionAddressDetail(attractionDTO.getAttractionAddressDetail())
                .attractionPrice(attractionDTO.getAttractionPrice())
                .build();

    }



//    public AttractionDTO(Attraction attraction){
//        this.attractionId = attraction.getAttractionId();
//        this.attractionName = attraction.getAttractionName();
//        this.attractionAddress = attraction.getAttractionAddress();
//        this.attractionAddressDetail = attraction.getAttractionAddressDetail();
//        this.attractionPrice = attraction.getAttractionPrice();
//    }
}

