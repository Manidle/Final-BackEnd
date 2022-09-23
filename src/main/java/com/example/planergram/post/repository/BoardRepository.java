package com.example.planergram.post.repository;

import com.example.planergram.post.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
