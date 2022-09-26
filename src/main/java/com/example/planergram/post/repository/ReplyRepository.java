package com.example.planergram.post.repository;

import com.example.planergram.post.model.Post;
import com.example.planergram.post.model.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
    List<Reply> findByPost(Post post);
}