package com.example.planergram.DTO;

import lombok.*;

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class StayLikeDTO {
    private int id;
    private int userId;
    private int stayId;
}
