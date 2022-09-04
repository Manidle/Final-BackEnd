package com.example.planergram.DTO;

import lombok.*;

import java.util.List;

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class UserDTO {
    private Long userId;

    private String loginId;
    private String password;
    private String nickname;

    private UserInfoDTO userInfoDTO;

    private List<Long> postDTOList;

    private List<Long> stayLikeIdList;
    private List<Long> rentCarLikeIdList;
    private List<Long> trainLikeIdList;
}
