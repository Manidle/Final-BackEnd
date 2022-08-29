package com.example.planergram.repository;

import com.example.planergram.model.Stay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StayRepository extends JpaRepository<Stay,Long> {
}
