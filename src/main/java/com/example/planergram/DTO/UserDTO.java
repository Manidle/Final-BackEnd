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
    private Long id;
    private String loginId;
    private String password;
    private String nickname;
    private Long userInfoId;
    private List<Long> stayLikeIdList;
}
