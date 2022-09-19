package com.example.planergram.travelContents.DTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.time.LocalTime;
import java.util.List;

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class StayDTO {

    private Long id;

    @ApiModelProperty(value = "숙소이름",example = "행복펜션",required = true)
    private String name;

    @ApiModelProperty(value = "숙소주소",example = "인천광역시 계양구 용종동동",required = true)
    private String address;

    @ApiModelProperty(value = "1박당 가격",example = "130000",required = true)
    private int price;

    @ApiModelProperty(value = "체크인 시각",example = "15:00",required = true)
    private LocalTime checkIn;

    @ApiModelProperty(value = "체크아웃 시각",example = "11:00",required = true)
    private LocalTime checkOut;

    @ApiModelProperty(value = "좋아요 숫자",example = "0",required = true)
    private int likeCount;

    @ApiModelProperty(hidden = true)
    private List<Long> stayLikeIdList;
}