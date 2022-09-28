package com.example.planergram.userLike.repository;

import com.example.planergram.travelContents.model.RentCar;
import com.example.planergram.userLike.model.RentCarLike;
import com.example.planergram.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentCarLikeRepository extends JpaRepository<RentCarLike, Long> {
    RentCarLike findByUserAndRentCar(User user, RentCar rentCar);

    List<RentCarLike> findByUser(User user);

    List<RentCarLike> findByRentCar(RentCar rentCar);
}
