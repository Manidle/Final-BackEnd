package com.example.planergram.user.DTO;

import lombok.*;

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class UserInfoDTO {
    private Long id;
    private String profileImg;
    private String email;
    private Long userId;
}