package com.example.planergram.repository;

import com.example.planergram.model.RentCar;
import com.example.planergram.model.RentCarLike;
import com.example.planergram.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentCarLikeRepository extends JpaRepository<RentCarLike,Long> {
    RentCarLike findByUserAndRentCar(User user, RentCar rentCar);
    List<RentCarLike> findByUser(User user);
}
