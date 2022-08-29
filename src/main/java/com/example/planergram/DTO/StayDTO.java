package com.example.planergram.DTO;

import lombok.*;

import java.time.LocalTime;
import java.util.List;

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class StayDTO {
    private Long id;
    private String name;
    private String address;
    private int price;
    private LocalTime checkIn;
    private LocalTime checkOut;
    private int likeCount;
    private List<Long> stayLikeIdList;
}