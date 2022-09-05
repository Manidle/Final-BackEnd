package com.example.planergram.postTravel.DTO;

import lombok.*;

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class PostTrainDTO {
    private Long postTrainId;
    private Long postId;
    private Long trainId;
}
