package com.example.planergram.travelContents.repository;

import com.example.planergram.travelContents.model.Platform;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlatformRepository extends JpaRepository<Platform, Long> {
    Platform findByNodeName(String nodeName);

    List<Platform> findAll();
}
