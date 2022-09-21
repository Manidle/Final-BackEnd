package com.example.planergram.travelContents.DTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrainDTO {

    private Long trainId;

    @ApiModelProperty(value = "출발시각",example = "2022-09-01T12:00",required = true)
    private LocalDateTime departureTime;

    @ApiModelProperty(value = "도착시각",example = "2022-09-01T15:00",required = true)
    private LocalDateTime arriveTime;

    @ApiModelProperty(value = "출발역",example = "서울역",required = true)
    private String startPoint;

    @ApiModelProperty(value = "도착역",example = "부산역",required = true)
    private String endPoint;

    @ApiModelProperty(value = "기차표 가격",example = "61000",required = true)
    private int trainPrice;

    @ApiModelProperty(value = "좋아요 숫자",example = "0",required = true)
    private int likeCount;

}
