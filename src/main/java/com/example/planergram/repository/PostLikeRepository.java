package com.example.planergram.repository;

import com.example.planergram.model.Post;
import com.example.planergram.model.PostLike;
import com.example.planergram.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostLikeRepository  extends JpaRepository<PostLike, Long> {
    PostLike findByUserAndPost(User user, Post post);

    List<PostLike> findByUser(User user);
    List<PostLike> findByPost(Post post);
}