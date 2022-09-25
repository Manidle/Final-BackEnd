package com.example.planergram.post.DTO;

import com.example.planergram.post.model.Reply;
import com.example.planergram.postTravel.DTO.PostAttractionDTO;
import com.example.planergram.postTravel.DTO.PostRentCarDTO;
import com.example.planergram.postTravel.DTO.PostStayDTO;
import com.example.planergram.postTravel.DTO.PostTrainDTO;
import com.example.planergram.postTravel.model.PostAttraction;
import com.example.planergram.postTravel.model.PostRentCar;
import com.example.planergram.postTravel.model.PostStay;
import com.example.planergram.postTravel.model.PostTrain;
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
    
    @ApiModelProperty(value = "게시글의 조회수", example = "1")
    private int readCount;

    @ApiModelProperty(value = "게시글 작성자의 닉네임", example = "글로리")
    private String nickname;

    @ApiModelProperty(value = "게시글이 작성된 Board의 이름", example = "강릉")
    private String boardName;

    @ApiModelProperty(hidden = true)
    private Long boardId;

    @ApiModelProperty(hidden = true)
    private Long userId;

    @ApiModelProperty(hidden = true)
    private List<Long> replyList;

    @ApiModelProperty(hidden = true)
    private List<Long> postRentCarList;

    @ApiModelProperty(hidden = true)
    private List<Long> postStayList;

    @ApiModelProperty(hidden = true)
    private List<Long> postTrainList;

    @ApiModelProperty(hidden = true)
    private List<Long> postAttractionList;

    @ApiModelProperty(hidden = true)
    private List<ReplyDTO> replys;

    @ApiModelProperty(hidden = true)
    private List<PostRentCarDTO> postRentCars;

    @ApiModelProperty(hidden = true)
    private List<PostStayDTO> postStays;

    @ApiModelProperty(hidden = true)
    private List<PostTrainDTO> postTrains;

    @ApiModelProperty(hidden = true)
    private List<PostAttractionDTO> postAttractions;

//===============================================================================================
//================================활용 x 차후 Develop때 사용예정 ====================================
//================================================================================================

//    @ApiModelProperty(hidden = true)
//    private String detailAddress;
//
//    @ApiModelProperty(hidden = true)
//    private String address;
}
