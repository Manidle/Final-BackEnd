package com.example.planergram.repository;

import com.example.planergram.model.UserHasAttraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserHasAttractionRepository extends JpaRepository<UserHasAttraction, Integer> {
}
