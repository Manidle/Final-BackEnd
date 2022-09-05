package com.example.planergram.service;

import com.example.planergram.userLike.DTO.PostLikeDTO;
import com.example.planergram.model.Post;
import com.example.planergram.model.PostLike;
import com.example.planergram.model.User;
import com.example.planergram.repository.PostLikeRepository;
import com.example.planergram.repository.PostRepository;
import com.example.planergram.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    
    public PostLikeDTO findById(Long id){
        PostLike postLike = postLikeRepository.getById(id);
        return makePostLikeDTO(postLike);
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

    public List<PostLikeDTO> findByUser(Long userId) {
        User user = userRepository.getById(userId);
        List<PostLike> postLikeList = postLikeRepository.findByUser(user);
        return makePostLikeDTOList(postLikeList);
    }

    public List<PostLikeDTO> findByPost(Long postId){
        Post post = postRepository.getById(postId);
        List<PostLike> postLikeList = postLikeRepository.findByPost(post);
        return makePostLikeDTOList(postLikeList);
    }

    private List<PostLikeDTO> makePostLikeDTOList(List<PostLike> postLikeList){
        List<PostLikeDTO> postLikeDTOList = new ArrayList<>();
        for(PostLike postLike:postLikeList){
            postLikeDTOList.add(makePostLikeDTO(postLike));
        }
        return postLikeDTOList;
    }

    private PostLikeDTO makePostLikeDTO(PostLike postLike){
        return PostLikeDTO.builder()
                .id(postLike.getId())
                .userId(postLike.getUser().getUserId())
                .postId(postLike.getPost().getPostId())
                .build();
    }
}
