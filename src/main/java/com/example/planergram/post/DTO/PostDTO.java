package com.example.planergram.post.DTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostDTO {

    @ApiModelProperty(value = "게시글의 ID", example = "1")
    private Long postId;

    @ApiModelProperty(value = "게시글의 제목", example = "test title")
    private String title;

    @ApiModelProperty(value = "게시글의 내용", example = "test contents")
    private String contents;

    @ApiModelProperty(value = "게시글의 좋아요", example = "1")
    private int likeCount;

    @ApiModelProperty(hidden = true)
    private Long boardId;

    @ApiModelProperty(value = "유저의 ID", example = "1")
    private Long userId;

    @ApiModelProperty(hidden = true)
    private List<Long> postStayList;

    @ApiModelProperty(hidden = true)
    private List<Long> postRentCarList;

    @ApiModelProperty(hidden = true)
    private List<Long> postTrainList;

    @ApiModelProperty(hidden = true)
    private List<Long> postAttractionList;
}
