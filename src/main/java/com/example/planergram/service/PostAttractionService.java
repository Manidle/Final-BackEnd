package com.example.planergram.service;

import com.example.planergram.DTO.PostAttractionDTO;
import com.example.planergram.model.Attraction;
import com.example.planergram.model.Post;
import com.example.planergram.model.PostAttraction;
import com.example.planergram.repository.AttractionRepository;
import com.example.planergram.repository.PostAttractionRepository;
import com.example.planergram.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<PostAttractionDTO> findByPost(Long postId) {
        Post post = postRepository.getById(postId);
        List<PostAttraction> postAttractionList = postAttractionRepository.findByPost(post);
        return makePostAttractionDTOList(postAttractionList);
    }

    public List<PostAttractionDTO> findByAttraction(Long attractionId) {
        Attraction attraction = attractionRepository.getById(attractionId);
        List<PostAttraction> postAttractionList = postAttractionRepository.findByAttraction(attraction);
        return makePostAttractionDTOList(postAttractionList);
    }

    public PostAttractionDTO findById(Long id) {
        PostAttraction postAttraction = postAttractionRepository.getById(id);
        return makePostAttractionDTO(postAttraction);
    }

    private PostAttractionDTO makePostAttractionDTO(PostAttraction postAttraction){
        return PostAttractionDTO.builder()
                .postAttractionId(postAttraction.getPostAttractionId())
                .postId(postAttraction.getPost().getPostId())
                .attractionId(postAttraction.getAttraction().getAttractionId())
                .build();
    }

    private List<PostAttractionDTO> makePostAttractionDTOList(List<PostAttraction> postAttractionList) {
        List<PostAttractionDTO> postAttractionDTOList = new ArrayList<>();
        for (PostAttraction postAttraction:postAttractionList){
            postAttractionDTOList.add(makePostAttractionDTO(postAttraction));
        }
        return postAttractionDTOList;
    }
}
