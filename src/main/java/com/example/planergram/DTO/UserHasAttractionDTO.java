package com.example.planergram.DTO;

import com.example.planergram.model.Train;
import com.example.planergram.model.UserHasAttraction;
import lombok.*;

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class UserHasAttractionDTO {
    private Long userHasAttractionId;
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
