package com.example.planergram.travelContents.model;


import com.example.planergram.postTravel.model.PostTrain;
import com.example.planergram.userLike.model.StayLike;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Train {

    @Id
    @Column(name="train_id",nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trainId;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Column(name = "departure_time")
    private LocalDateTime departureTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Column(name = "arrive_time")
    private LocalDateTime arriveTime;

    @Column(name = "start_point")
    private String startPoint;

    @Column(name = "end_point")
    private String endPoint;

    @Column(name = "train_price")
    private int trainPrice;

    @Column(name = "like_count")
    private int likeCount;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "stay",cascade = CascadeType.ALL)
    private List<StayLike> stayLikeList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "train",cascade = CascadeType.ALL)
    private List<PostTrain> postTrainList;
}
