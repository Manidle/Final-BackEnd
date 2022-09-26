package com.example.planergram.travelContents.DTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class RentCarDTO {

    private Long rentCarId;

    @ApiModelProperty(value = "렌트카 업체주소", example = "강원도", required = true)
    private String address;

    @ApiModelProperty(value = "렌트카 업체명", example = "씽씽렌트카", required = true)
    private String companyName;

    @ApiModelProperty(value = "차 크기종류", example = "중형", required = true)
    private String carSort;

    @ApiModelProperty(value = "차 이름", example = "k5", required = true)
    private String carName;

    @ApiModelProperty(value = "좋아요 숫자", example = "0", required = true)
    private int likeCount;

    @ApiModelProperty(hidden = true)
    private List<Long> rentCarLikeIdList;
}
