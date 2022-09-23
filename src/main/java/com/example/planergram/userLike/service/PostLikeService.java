package com.example.planergram.userLike.service;

import com.example.planergram.userLike.DTO.PostLikeDTO;
import com.example.planergram.post.model.Post;
import com.example.planergram.userLike.model.PostLike;
import com.example.planergram.user.model.User;
import com.example.planergram.userLike.repository.PostLikeRepository;
import com.example.planergram.post.repository.PostRepository;
import com.example.planergram.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
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
        log.info("PostLike click : user, post Entity 가져옴");
        PostLike postLike = postLikeRepository.findByUserAndPost(user,post);
        log.info("PostLike click : 가져온 user, post를 바탕으로 postLike 조회");

        if (postLike == null){
            log.info("PostLike : 좋아요를 누르기");
            return likeClick(user, post);
        }
        log.info("PostLike : 좋아요를 취소");
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
