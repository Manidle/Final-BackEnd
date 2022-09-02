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
@Table(name = "post_rentCar")
public class PostRentCar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_rentcar_id")
    private Long PostRentCarId;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = RentCar.class)
    @JoinColumn(name = "rentcar_id")
    private RentCar rentCar;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Post.class)
    @JoinColumn(name = "post_id")
    private Post post;
}
