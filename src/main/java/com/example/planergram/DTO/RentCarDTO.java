package com.example.planergram.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RentCarDTO {

    private int rentCarId;
    private String address;
    private String companyName;
    private String carSort;
    private String carName;
}
