package com.example.planergram.repository;

import com.example.planergram.model.Stay;
import com.example.planergram.model.StayLike;
import com.example.planergram.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StayLikeRepository extends JpaRepository<StayLike,Long> {
    StayLike findByUserAndStay(User user, Stay stay);
    List<StayLike> findByUser(User user);
    List<StayLike> findByStay(Stay stay);

}
