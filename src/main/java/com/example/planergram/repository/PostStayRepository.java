package com.example.planergram.repository;

import com.example.planergram.model.Post;
import com.example.planergram.model.PostStay;
import com.example.planergram.model.Stay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostStayRepository extends JpaRepository<PostStay, Long> {
    PostStay findByPostAndStay(Post post, Stay stay);
}
