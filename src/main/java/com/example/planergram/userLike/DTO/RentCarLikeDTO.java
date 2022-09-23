package com.example.planergram.userLike.DTO;

import lombok.*;

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class RentCarLikeDTO {
    private Long rentCarLikeId;
    private Long userId;
    private Long rentCarId;
}
