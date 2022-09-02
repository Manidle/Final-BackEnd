package com.example.planergram.DTO;

import lombok.*;

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class PostLikeDTO {
    private Long id;
    private Long userId;
    private Long postId;
}
