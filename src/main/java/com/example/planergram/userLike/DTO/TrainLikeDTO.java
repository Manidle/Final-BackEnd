package com.example.planergram.userLike.DTO;

import lombok.*;

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class TrainLikeDTO {
    private Long trainLikeId;
    private Long userId;
    private Long trainId;

    private String depplacename;
    private String arrplacename;
    private String depplandtime;
    private String arrplandtime;
    private int adultcharge;
    private int trainno;
}
