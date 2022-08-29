package com.example.planergram.DTO;

import lombok.*;

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class StayLikeDTO {
    private Long id;
    private Long userId;
    private Long stayId;
}
