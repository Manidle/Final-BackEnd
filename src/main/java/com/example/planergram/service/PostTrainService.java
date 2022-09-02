package com.example.planergram.service;

import com.example.planergram.model.*;
import com.example.planergram.repository.PostRepository;
import com.example.planergram.repository.PostTrainRepository;
import com.example.planergram.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostTrainService {

    @Autowired
    private PostTrainRepository postTrainRepository;

    @Autowired
    private TrainRepository trainRepository;

    @Autowired
    private PostRepository postRepository;

    public String clickTrainLike(Long postId, Long trainId) {
        Post post = postRepository.getById(postId);
        Train train = trainRepository.getById(trainId);
        PostTrain postTrain = postTrainRepository.findByPostAndTrain(post,train);
        if (postTrain == null){
            return likeClick(post, train);
        }
        return likeCancel(postTrain);
    }


    private String likeClick(Post post,Train train){
        PostTrain postTrain = PostTrain.builder()
                .train(train)
                .post(post)
                .build();
        postTrainRepository.save(postTrain);
        return "게시글에 해당 기차를 추가했습니다";
    }

    private String likeCancel(PostTrain postTrain){
        postTrainRepository.delete(postTrain);
        return "게시글에 해당 기차를 제거했습니다";
    }
}
