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
public class BoardDTO {

    @ApiModelProperty(value = "게시판의 ID", example = "1")
    private Long boardId;
    @ApiModelProperty(value = "게시판의 이르", example = "서울")
    private String boardTitle;

    @ApiModelProperty(value = "게시판의 이미지", example = "soul.jpg")
    private String img;

    @ApiModelProperty(hidden = true)
    private List<Long> postDTOList;
}
