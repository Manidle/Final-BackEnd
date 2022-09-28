package com.example.planergram.postTravel.repository;

import com.example.planergram.post.model.Post;
import com.example.planergram.postTravel.model.PostTrain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostTrainRepository extends JpaRepository<PostTrain, Long> {
    PostTrain findByPostAndTrainno(Post post, int trainno);

    List<PostTrain> findByPost(Post post);
}
