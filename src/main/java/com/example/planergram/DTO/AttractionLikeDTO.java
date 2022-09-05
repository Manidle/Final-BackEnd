package com.example.planergram.DTO;

import lombok.*;

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class AttractionLikeDTO {
    private Long id;
    private Long userId;
    private Long attractionId;
}