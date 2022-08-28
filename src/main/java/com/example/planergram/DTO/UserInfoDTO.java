package com.example.planergram.DTO;

import lombok.*;

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class UserInfoDTO {
    private int id;
    private String profileImg;
    private String email;
    private int userId;
}