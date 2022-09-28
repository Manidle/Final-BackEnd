package com.example.planergram.travelContents.DTO;

import lombok.*;

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class PlatformDTO {
    private Long platformId;
    private int cityCode;
    private String cityName;
    private String nodeId;
    private String nodeName;
}
