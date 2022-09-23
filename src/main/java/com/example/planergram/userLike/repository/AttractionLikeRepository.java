package com.example.planergram.userLike.repository;

import com.example.planergram.travelContents.model.Attraction;
import com.example.planergram.userLike.model.AttractionLike;
import com.example.planergram.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttractionLikeRepository extends JpaRepository<AttractionLike, Long> {
    AttractionLike findByUserAndAttraction(User user, Attraction attraction);

    List<AttractionLike> findByUser(User user);

    List<AttractionLike> findByAttraction(Attraction attraction);
}
