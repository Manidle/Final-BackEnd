package com.example.planergram.repository;

import com.example.planergram.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostTrainRepository extends JpaRepository<PostTrain,Long> {
    PostTrain findByPostAndTrain(Post post, Train train);

    List<PostTrain> findByPost(Post post);
    List<PostTrain> findByTrain(Train train);
}
