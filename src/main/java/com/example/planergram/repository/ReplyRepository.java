package com.example.planergram.repository;

import com.example.planergram.model.Post;
import com.example.planergram.model.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository  extends JpaRepository<Reply,Long> {
    List<Reply> findByPost(Post post);
}
