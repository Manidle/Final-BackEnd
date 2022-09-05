package com.example.planergram.repository;

import com.example.planergram.model.Attraction;
import com.example.planergram.model.AttractionLike;
import com.example.planergram.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttractionLikeRepository extends JpaRepository<AttractionLike, Long> {
    AttractionLike findByUserAndAttraction(User user, Attraction attraction);
}
