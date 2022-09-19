package com.example.planergram.travelContents.DTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;


@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class AttractionDTO {

    private Long attractionId;

    @ApiModelProperty(value = "관광지 명",example = "MAN I-DLE 동상",required = true)
    private String name;

    @ApiModelProperty(value = "관광지 전체주소",example = "서울특별시 서초구 교대역",required = true)
    private String addressDetail;

    @ApiModelProperty(value = "관광지 지역주소",example = "서울특별시",required = true)
    private String address;

    @ApiModelProperty(value = "관람료",example = "5000",required = true)
    private Integer price;

    @ApiModelProperty(value = "좋아요 숫자",example = "0",required = true)
    private int likeCount;
}

