package com.example.planergram.model;

import lombok.*;

import javax.persistence.*;

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
@Entity
@Table(name = "attraction_Like")
public class AttractionLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attraction_like_id")
    private Long attractionLikeId;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = AttractionLike.class)
    @JoinColumn(name = "attraction_id")
    private Attraction attraction;
}
