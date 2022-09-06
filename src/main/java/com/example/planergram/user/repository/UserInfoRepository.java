package com.example.planergram.user.repository;

import com.example.planergram.user.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserInfoRepository  extends JpaRepository<UserInfo,Long> {
    UserInfo findByEmail(String email);
}
