package com.example.planergram.user.repository;

import com.example.planergram.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long>{
    User findByNickname(String nickname);
    User findByLoginId(String loginId);
}
