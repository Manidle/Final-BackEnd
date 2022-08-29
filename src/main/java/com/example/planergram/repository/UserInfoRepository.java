package com.example.planergram.repository;

import com.example.planergram.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository  extends JpaRepository<UserInfo,Long> {
}
