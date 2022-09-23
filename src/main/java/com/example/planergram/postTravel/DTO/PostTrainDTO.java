package com.example.planergram.postTravel.DTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class PostTrainDTO {
    @ApiModelProperty(value = "PostTrain의 ID", example = "1")
    private Long postTrainId;
    @ApiModelProperty(value = "Post의 ID", example = "1")
    private Long postId;
    @ApiModelProperty(value = "Train의 ID", example = "1")
    private Long trainId;
}
