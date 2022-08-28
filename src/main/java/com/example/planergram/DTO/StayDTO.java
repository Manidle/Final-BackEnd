package com.example.planergram.DTO;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class StayDTO {
    private int id;
    private String name;
    private String address;
    private int price;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private int likeCount;
    private List<Integer> stayLikeIdList;
}