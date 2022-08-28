package com.example.planergram.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
@Entity
@Table(name = "stay")
public class Stay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stay_id")
    private int id;

    @Column(length = 30)
    private String name;

    @Column(nullable = false,length = 100, unique = true)
    private String address;

    @Column(nullable = false)
    private int price;

    @Column(name = "check_in")
    private LocalDate checkIn;

    @Column(name = "check_out")
    private LocalDate checkOut;

    @Column(name = "like_count")
    private int likeCount;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private List<StayLike> stayLikeList;
}
