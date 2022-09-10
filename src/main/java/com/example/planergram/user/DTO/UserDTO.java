package com.example.planergram.user.DTO;

import io.swagger.annotations.ApiModelProperty;
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

    @ApiModelProperty(value = "사용자의 로그인 ID",example = "testlogin01",required = true)
    private String loginId;
    @ApiModelProperty(value = "사용자의 password",example = "12341234",required = true)
    private String password;
    private String nickname;

    private UserInfoDTO userInfoDTO;

    private List<Long> postDTOList;

    private List<Long> stayLikeIdList;
    private List<Long> rentCarLikeIdList;
    private List<Long> trainLikeIdList;
    private List<Long> postLikeIdList;
}
