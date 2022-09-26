package com.example.planergram.post.repository;

import com.example.planergram.post.model.Board;
import com.example.planergram.post.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByBoard(Board board);

    List<Post> findByBoardAndTitleLike(Board board, String title);

    List<Post> findTop9ByOrderByLikeCountDesc();
}
