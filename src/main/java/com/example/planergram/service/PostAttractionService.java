package com.example.planergram.service;

import com.example.planergram.model.Attraction;
import com.example.planergram.model.Post;
import com.example.planergram.model.PostAttraction;
import com.example.planergram.repository.AttractionRepository;
import com.example.planergram.repository.PostAttractionRepository;
import com.example.planergram.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostAttractionService {

    @Autowired
    private PostAttractionRepository postAttractionRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private AttractionRepository attractionRepository;

    public String clickPostAttraction(Long postId, Long attractionId) {
        Post post = postRepository.getById(postId);
        Attraction attraction = attractionRepository.getById(attractionId);
        PostAttraction postAttraction = postAttractionRepository.findByPostAndAttraction(post,attraction);
        if (postAttraction == null){
            return postClick(post,attraction);
        }
        return clickCancel(postAttraction);
    }

    private String postClick(Post post, Attraction attraction) {
        PostAttraction postAttraction = PostAttraction.builder()
                .attraction(attraction)
                .post(post)
                .build();
        postAttractionRepository.save(postAttraction);
        return "포스트에 추가";
    }
    private String clickCancel(PostAttraction postAttraction) {
        postAttractionRepository.delete(postAttraction);
        return "포스트에서 제거";
    }

}
