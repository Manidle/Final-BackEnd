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

    @ApiModelProperty(hidden = true)
    private Long postTrainId;

    @ApiModelProperty(hidden = true)
    private Long postId;

    @ApiModelProperty(value = "출발역", example = "서울")
    private String depplacename;

    @ApiModelProperty(value = "도착역", example = "대전")
    private String arrplacename;

    @ApiModelProperty(value = "출발시간", example = "20210505051500")
    private String depplandtime;

    @ApiModelProperty(value = "도착시간", example = "20210505061200")
    private String arrplandtime;

    @ApiModelProperty(value = "요금", example = "23700")
    private int adultcharge;

    @ApiModelProperty(value = "기차번호", example = "1")
    private int trainno;

    @ApiModelProperty(hidden = true)
    private String depplaceNodeName;

    @ApiModelProperty(hidden = true)
    private String arrplaceNodeName;
}
