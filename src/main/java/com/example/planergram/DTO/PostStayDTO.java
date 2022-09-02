package com.example.planergram.DTO;

import lombok.*;

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class PostStayDTO {
    private Long id;
    private Long postId;
    private Long stayId;
}
