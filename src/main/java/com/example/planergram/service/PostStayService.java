package com.example.planergram.service;

import com.example.planergram.DTO.PostStayDTO;
import com.example.planergram.model.Post;
import com.example.planergram.model.PostStay;
import com.example.planergram.model.Stay;
import com.example.planergram.repository.PostRepository;
import com.example.planergram.repository.PostStayRepository;
import com.example.planergram.repository.StayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostStayService {

    @Autowired
    private PostStayRepository postStayRepository;

    @Autowired
    private StayRepository stayRepository;

    @Autowired
    private PostRepository postRepository;

    public String clickStayLike(Long postId, Long stayId) {
        Post post = postRepository.getById(postId);
        Stay stay = stayRepository.getById(stayId);
        PostStay postStay = postStayRepository.findByPostAndStay(post,stay);
        if (postStay == null){
            return likeClick(post, stay);
        }
        return likeCancel(postStay);
    }


    private String likeClick(Post post,Stay stay){
        PostStay postStay = PostStay.builder()
                .stay(stay)
                .post(post)
                .build();
        postStayRepository.save(postStay);
        return "좋아요 클릭";
    }

    private String likeCancel(PostStay postStay){
        postStayRepository.delete(postStay);
        return "좋아요 취소";
    }

    public List<PostStayDTO> findByPost(Long postId) {
        Post post = postRepository.getById(postId);
        List<PostStay> postStayList = postStayRepository.findByPost(post);
        return makePostStayDTOList(postStayList);
    }

    private PostStayDTO makePostStayDTO(PostStay postStay){
        return PostStayDTO.builder()
                .stayId(postStay.getId())
                .postId(postStay.getPost().getPostId())
                .stayId(postStay.getStay().getId())
                .build();
    }

    private List<PostStayDTO> makePostStayDTOList(List<PostStay> postStayList){
        List<PostStayDTO> postStayDTOList = new ArrayList<>();
        for (PostStay postStay: postStayList){
            postStayDTOList.add(makePostStayDTO(postStay));
        }
        return postStayDTOList;
    }
}
