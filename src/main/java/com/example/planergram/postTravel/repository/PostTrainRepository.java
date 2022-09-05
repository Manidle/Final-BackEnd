package com.example.planergram.postTravel.repository;

import com.example.planergram.post.model.Post;
import com.example.planergram.postTravel.model.PostTrain;
import com.example.planergram.travelContents.model.Train;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostTrainRepository extends JpaRepository<PostTrain,Long> {
    PostTrain findByPostAndTrain(Post post, Train train);

    List<PostTrain> findByPost(Post post);
    List<PostTrain> findByTrain(Train train);
}
