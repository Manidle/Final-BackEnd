package com.example.planergram.postTravel.DTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class PostAttractionDTO {
    @ApiModelProperty(value = "PostAttraction의 ID", example = "1")
    private Long postAttractionId;
    @ApiModelProperty(value = "Post의 ID", example = "1")
    private Long postId;
    @ApiModelProperty(value = "Attraction의 ID", example = "1")
    private Long attractionId;
}
