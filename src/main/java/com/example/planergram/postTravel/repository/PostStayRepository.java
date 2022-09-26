package com.example.planergram.postTravel.repository;

import com.example.planergram.post.model.Post;
import com.example.planergram.postTravel.model.PostStay;
import com.example.planergram.travelContents.model.Stay;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostStayRepository extends JpaRepository<PostStay, Long> {
    PostStay findByPostAndStay(Post post, Stay stay);

    List<PostStay> findByPost(Post post);

    List<PostStay> findByStay(Stay stay);
}
