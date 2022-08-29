package com.example.planergram.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostDTO {

    private String title;
    private String contents;
    private int likeCount;

    private int postId;
    private int boardId;
    private int userId;

}
