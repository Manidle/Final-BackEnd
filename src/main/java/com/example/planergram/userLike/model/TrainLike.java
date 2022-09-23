package com.example.planergram.userLike.model;

import com.example.planergram.travelContents.model.Train;
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
@Table(name = "train_like")
public class TrainLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "train_like_id")
    private Long trainLikeId;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Train.class)
    @JoinColumn(name = "train_id")
    private Train train;
}
