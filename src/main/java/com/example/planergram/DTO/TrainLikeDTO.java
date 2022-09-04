package com.example.planergram.DTO;

import lombok.*;

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class TrainLikeDTO {
    private Long trainLikeId;
    private Long userId;
    private Long trainId;
}
