package com.example.planergram.service;

import com.example.planergram.model.*;
import com.example.planergram.repository.PostRentCarRepository;
import com.example.planergram.repository.PostRepository;
import com.example.planergram.repository.RentCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostRentCarService {
    @Autowired
    private PostRentCarRepository postRentCarRepository;

    @Autowired
    private RentCarRepository rentCarRepository;

    @Autowired
    private PostRepository postRepository;

    public String clickRentCarLike(Long postId, Long rentCarId) {
        Post post = postRepository.getById(postId);
        RentCar rentCar = rentCarRepository.getById(rentCarId);
        PostRentCar postRentCar = postRentCarRepository.findByPostAndRentCar(post,rentCar);
        if (postRentCar == null){
            return likeClick(post, rentCar);
        }
        return likeCancel(postRentCar);
    }

    private String likeClick(Post post, RentCar rentCar){
        PostRentCar postRentCar = PostRentCar.builder()
                .rentCar(rentCar)
                .post(post)
                .build();
        postRentCarRepository.save(postRentCar);
        return "좋아요 클릭";
    }

    private String likeCancel(PostRentCar postRentCar){
        postRentCarRepository.delete(postRentCar);
        return "좋아요 취소";
    }


}
