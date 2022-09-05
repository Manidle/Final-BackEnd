package com.example.planergram.postTravel.repository;

import com.example.planergram.travelContents.model.Attraction;
import com.example.planergram.post.model.Post;
import com.example.planergram.postTravel.model.PostAttraction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostAttractionRepository extends JpaRepository<PostAttraction, Long> {
    PostAttraction findByPostAndAttraction(Post post, Attraction attraction);

    List<PostAttraction> findByPost(Post post);

    List<PostAttraction> findByAttraction(Attraction attraction);
}
