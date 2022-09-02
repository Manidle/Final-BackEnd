package com.example.planergram.DTO;

import lombok.*;

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class PostRentCarDTO {
    private Long postRentCarId;
    private Long postId;
    private Long rentCarId;
}