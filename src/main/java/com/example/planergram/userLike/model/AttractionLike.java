package com.example.planergram.userLike.model;

import com.example.planergram.travelContents.model.Attraction;
import com.example.planergram.user.model.User;
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
