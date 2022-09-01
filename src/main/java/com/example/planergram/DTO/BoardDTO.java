package com.example.planergram.DTO;

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

    private Long boardId;
    private String boardTitle;
    private String img;
    private List<Long> postDTOList;
}