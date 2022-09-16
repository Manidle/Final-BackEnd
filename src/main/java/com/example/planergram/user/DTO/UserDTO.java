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

    @ApiModelProperty(value = "사용자의 로그인 id",example = "testlogin01",required = true)
    private String username;

    @ApiModelProperty(value = "사용자의 패스워드",example = "123456789",required = true)
    private String password;

    @ApiModelProperty(value = "사용자의 닉네임",example = "플래너그램",required = true)
    private String nickname;

    private String roles; // USER,ADMIN

    private UserInfoDTO userInfoDTO;

    private List<Long> postDTOList;

    private List<Long> stayLikeIdList;
    private List<Long> rentCarLikeIdList;
    private List<Long> trainLikeIdList;
    private List<Long> postLikeIdList;


}
