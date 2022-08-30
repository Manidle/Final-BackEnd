package com.example.planergram.DTO;

import com.example.planergram.model.Train;
import com.example.planergram.model.UserHasAttraction;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserHasAttractionDTO {
    private Long userId;
    private Long attractionId;


    private UserHasAttractionDTO toUserHasAttractionDTO(UserHasAttraction userHasAttraction){
        return UserHasAttractionDTO.builder()
                .userId(userHasAttraction.getUserId())
                .attractionId(userHasAttraction.getAttractionId())
                .build();
    }

    private UserHasAttraction toUserHasAttraction(UserHasAttractionDTO userHasAttractionDTO){
        return UserHasAttraction.builder()
                .userId(userHasAttractionDTO.getUserId())
                .attractionId(userHasAttractionDTO.getAttractionId())
                .build();
    }

}