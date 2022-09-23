package com.example.planergram.travelContents.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Platform {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "platform_id")
    private Long platformId;

    @Column(name = "city_Code", nullable = false)
    private int cityCode;

    @Column(name = "city_Name", nullable = false)
    private String cityName;

    @Column(name = "node_Id", nullable = false)
    private String nodeId;

    @Column(name = "node_Name", nullable = false)
    private String nodeName;
}