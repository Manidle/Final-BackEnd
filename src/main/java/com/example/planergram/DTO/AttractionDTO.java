package com.example.planergram.DTO;

import lombok.*;


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
}

