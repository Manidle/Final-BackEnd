package com.example.planergram.userLike.model;

import com.example.planergram.travelContents.model.Stay;
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
@Table(name = "stay_like")
public class StayLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stay_like_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Stay.class)
    @JoinColumn(name = "stay_id")
    private Stay stay;
}
