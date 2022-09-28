package com.example.planergram.travelContents.model;


import com.example.planergram.userLike.model.AttractionLike;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Attraction {

    @Id
    @Column(name = "attraction_id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attractionId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Lob
    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private int price;

    @Column(name = "like_count")
    private int likeCount;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "attraction", cascade = CascadeType.ALL)
    private List<AttractionLike> attractionLikeList;
}
