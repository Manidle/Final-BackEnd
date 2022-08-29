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
public class UserDTO {

    private int userId;
    private String loginId;
    private String password;
    private String nickname;
    private List<Integer> postDTOList;
//    private List<String> postTitleDTOList;
//    private List<String> postContentDTOList;
}
