package com.example.planergram.postTravel.DTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class PostStayDTO {
    @ApiModelProperty(value = "PostStay의 ID", example = "1")
    private Long postStayId;
    @ApiModelProperty(value = "Post의 ID", example = "1")
    private Long postId;
    @ApiModelProperty(value = "Stay의 ID", example = "1")
    private Long stayId;
}
