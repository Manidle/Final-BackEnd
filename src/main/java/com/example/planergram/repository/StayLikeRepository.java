package com.example.planergram.repository;

import com.example.planergram.model.Stay;
import com.example.planergram.model.StayLike;
import com.example.planergram.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StayLikeRepository extends JpaRepository<StayLike,Integer> {
    StayLike findByUserAndStay(User user, Stay stay);
}
