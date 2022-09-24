package com.example.planergram.postTravel.DTO;

import lombok.*;

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class PostTrainDTO {

    private Long postTrainId;
    private Long postId;
    private Long trainId;

    private String depplacename;
    private String arrplacename;
    private String depplandtime;
    private String arrplandtime;
    private int adultcharge;
    private int trainno;
}
