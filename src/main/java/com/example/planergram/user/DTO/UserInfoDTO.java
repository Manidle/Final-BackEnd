package com.example.planergram.user.DTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class UserInfoDTO {
    private Long id;

    @ApiModelProperty(value = "사용자의 프로필이미지 URL", example = "https://image10.coupangcdn.com/image/mobile/v3/img_fb_like.png", required = true)
    private String profileImg;

    @ApiModelProperty(value = "사용자의 이메일", example = "planergram@naver.com", required = true)
    private String email;

    @ApiModelProperty(hidden = true)
    private Long userId;
}