package com.example.planergram.DTO;

import lombok.*;

import java.util.List;

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class RentCarDTO {

    private Long rentCarId;
    private String address;
    private String companyName;
    private String carSort;
    private String carName;
    private int likeCount;
    private List<Long> rentCarLikeIdList;
}
