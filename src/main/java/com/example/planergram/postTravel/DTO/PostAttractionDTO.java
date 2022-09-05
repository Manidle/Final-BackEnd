package com.example.planergram.postTravel.DTO;

import lombok.*;

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class PostAttractionDTO {
    private Long postAttractionId;
    private Long postId;
    private Long attractionId;
}
