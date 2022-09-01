package com.example.planergram.service;

import com.example.planergram.model.Post;
import com.example.planergram.model.PostLike;
import com.example.planergram.model.User;
import com.example.planergram.repository.PostLikeRepository;
import com.example.planergram.repository.PostRepository;
import com.example.planergram.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostLikeService {

    @Autowired
    private PostLikeRepository postLikeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    public String clickPostLike(Long userId, Long postId){
        User user = userRepository.getById(userId);
        Post post = postRepository.getById(postId);

        PostLike postLike = postLikeRepository.findByUserAndPost(user,post);
        if (postLike == null){
            return likeClick(user, post);
        }
        return likeCancel(post, postLike);
    }

    private String likeClick(User user, Post post){
        post.setLikeCount(post.getLikeCount() + 1);
        postRepository.save(post);

        PostLike postLike = PostLike.builder()
                .post(post)
                .user(user)
                .build();
        postLikeRepository.save(postLike);
        return "좋아요 클릭";
    }

    private String likeCancel(Post post, PostLike postLike){
        post.setLikeCount(post.getLikeCount() - 1);
        postRepository.save(post);
        postLikeRepository.delete(postLike);
        return "좋아요 취소";
    }
}
