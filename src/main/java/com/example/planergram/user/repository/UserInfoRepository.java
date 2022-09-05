package com.example.planergram.user.repository;

import com.example.planergram.user.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository  extends JpaRepository<UserInfo,Long> {
}
