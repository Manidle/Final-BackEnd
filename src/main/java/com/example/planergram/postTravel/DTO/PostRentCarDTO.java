package com.example.planergram.postTravel.DTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class PostRentCarDTO {
    @ApiModelProperty(value = "PostRentCar의 ID", example = "1")
    private Long postRentCarId;
    @ApiModelProperty(value = "Post의 ID", example = "1")
    private Long postId;
    @ApiModelProperty(value = "RentCar의 ID", example = "1")
    private Long rentCarId;
}