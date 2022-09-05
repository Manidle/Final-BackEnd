package com.example.planergram.repository;

import com.example.planergram.model.Attraction;
import com.example.planergram.model.Post;
import com.example.planergram.model.PostAttraction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostAttractionRepository extends JpaRepository<PostAttraction, Long> {
    PostAttraction findByPostAndAttraction(Post post, Attraction attraction);

    List<PostAttraction> findByPost(Post post);

    List<PostAttraction> findByAttraction(Attraction attraction);
}
