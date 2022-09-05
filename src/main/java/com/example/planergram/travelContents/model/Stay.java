package com.example.planergram.travelContents.model;

import com.example.planergram.postTravel.model.PostStay;
import com.example.planergram.userLike.model.StayLike;
import lombok.*;

import javax.persistence.*;
import java.time.LocalTime;
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
    private Long id;

    @Column(length = 30)
    private String name;

    @Column(nullable = false,length = 100, unique = true)
    private String address;

    @Column(nullable = false)
    private int price;

    @Column(name = "check_in")
    private LocalTime checkIn;

    @Column(name = "check_out")
    private LocalTime checkOut;

    @Column(name = "like_count")
    private int likeCount;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "stay",cascade = CascadeType.ALL)
    private List<StayLike> stayLikeList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "stay",cascade = CascadeType.ALL)
    private List<PostStay> postStayList;
}
