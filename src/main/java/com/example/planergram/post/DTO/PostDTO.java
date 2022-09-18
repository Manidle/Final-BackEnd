package com.example.planergram.post.DTO;

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

    private Long postId;

    private String title;
    private String contents;

    private int likeCount;
    private int readCount;

    private Long boardId;
    private Long userId;

    private List<Long> postStayList;
    private List<Long> postRentCarList;
    private List<Long> postTrainList;
    private List<Long> postAttractionList;
}
