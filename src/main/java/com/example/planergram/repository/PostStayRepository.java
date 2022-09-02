package com.example.planergram.repository;

import com.example.planergram.model.Post;
import com.example.planergram.model.PostStay;
import com.example.planergram.model.Stay;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostStayRepository extends JpaRepository<PostStay, Long> {
    PostStay findByPostAndStay(Post post, Stay stay);

    List<PostStay> findByPost(Post post);
    List<PostStay> findByStay(Stay stay);

}
