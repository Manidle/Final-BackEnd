package com.example.planergram.userLike.model;

import com.example.planergram.travelContents.model.RentCar;
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
@Table(name = "RentCar_Like")
public class RentCarLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rentCar_like_id")
    private Long rentCarLikeId;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = RentCar.class)
    @JoinColumn(name = "rentCar_id")
    private RentCar rentCar;
}
