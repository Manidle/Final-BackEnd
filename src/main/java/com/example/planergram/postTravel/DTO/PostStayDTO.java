package com.example.planergram.postTravel.DTO;

import lombok.*;

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class PostStayDTO {
    private Long postStayId;
    private Long postId;
    private Long stayId;
}
