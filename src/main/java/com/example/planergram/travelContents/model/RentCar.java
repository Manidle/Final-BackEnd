package com.example.planergram.travelContents.model;

import com.example.planergram.postTravel.model.PostRentCar;
import com.example.planergram.userLike.model.RentCarLike;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class RentCar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rentcar_id")
    private Long rentCarId;

    @Column(nullable = false, length = 60)
    private String address;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name = "car_sort", nullable = false)
    private String carSort;

    @Column(name = "car_name", nullable = false)
    private String carName;

    @Column(name = "like_count")
    private int likeCount;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    private List<RentCarLike> rentCarLikeList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rentCar", cascade = CascadeType.ALL)
    private List<PostRentCar> postRentCarList;
}