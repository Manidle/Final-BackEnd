package com.example.planergram.DTO;

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
