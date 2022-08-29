package com.example.planergram.DTO;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ResponseDTO<T> {
    private String error;
}
