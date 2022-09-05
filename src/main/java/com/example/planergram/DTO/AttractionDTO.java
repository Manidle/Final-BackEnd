package com.example.planergram.DTO;

import lombok.*;

import javax.persistence.Column;


@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class AttractionDTO {
    private Long attractionId;
    private String name;
    private String addressDetail;
    private String address;
    private Integer price;
    private int likeCount;
}

