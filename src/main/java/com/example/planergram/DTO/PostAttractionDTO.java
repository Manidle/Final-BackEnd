package com.example.planergram.DTO;

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
