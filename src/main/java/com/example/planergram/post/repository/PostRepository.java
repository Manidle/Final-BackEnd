package com.example.planergram.post.repository;

import com.example.planergram.post.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByDetailAddressAndAddress(String detailAddress, String address);
    List<Post> findByAddress(String address);
    List<Post> findByTitleLike(String title);
    List<Post> findTop5ByOrderByLikeCountDesc();
}
