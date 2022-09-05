package com.example.planergram.userLike.repository;

import com.example.planergram.post.model.Post;
import com.example.planergram.userLike.model.PostLike;
import com.example.planergram.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostLikeRepository  extends JpaRepository<PostLike, Long> {
    PostLike findByUserAndPost(User user, Post post);

    List<PostLike> findByUser(User user);
    List<PostLike> findByPost(Post post);
}
