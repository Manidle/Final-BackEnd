package com.example.planergram.postTravel.service;

import com.example.planergram.postTravel.DTO.PostStayDTO;
import com.example.planergram.post.model.Post;
import com.example.planergram.postTravel.model.PostStay;
import com.example.planergram.travelContents.model.Stay;
import com.example.planergram.post.repository.PostRepository;
import com.example.planergram.postTravel.repository.PostStayRepository;
import com.example.planergram.travelContents.repository.StayRepository;
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
                .name(stay.getName())
                .address(stay.getAddress())
                .price(stay.getPrice())
                .checkIn(stay.getCheckIn())
                .checkOut(stay.getCheckOut())
                .likeCount(stay.getLikeCount())
                .build();
        postStayRepository.save(postStay);
        return "좋아요 클릭";
    }

    private String likeCancel(PostStay postStay){
        postStayRepository.delete(postStay);
        return "좋아요 취소";
    }

    public PostStayDTO findById(Long id){
        PostStay postStay = postStayRepository.getById(id);
        return makePostStayDTO(postStay);
    }

    public List<PostStayDTO> findByPost(Long postId) {
        Post post = postRepository.getById(postId);
        List<PostStay> postStayList = postStayRepository.findByPost(post);
        return makePostStayDTOList(postStayList);
    }

    public List<PostStayDTO> findByStay(Long stayId) {
        Stay stay = stayRepository.getById(stayId);
        List<PostStay> postStayList = postStayRepository.findByStay(stay);
        return makePostStayDTOList(postStayList);
    }

    static public PostStayDTO makePostStayDTO(PostStay postStay){
        return PostStayDTO.builder()
                .postStayId(postStay.getPostStayId())
                .postId(postStay.getPost().getPostId())
                .stayId(postStay.getStay().getId())
                .name(postStay.getName())
                .address(postStay.getAddress())
                .price(postStay.getPrice())
                .checkIn(postStay.getCheckIn())
                .checkOut(postStay.getCheckOut())
                .likeCount(postStay.getLikeCount())
                .build();
    }

    static public List<PostStayDTO> makePostStayDTOList(List<PostStay> postStayList){
        List<PostStayDTO> postStayDTOList = new ArrayList<>();
        for (PostStay postStay: postStayList){
            postStayDTOList.add(makePostStayDTO(postStay));
        }
        return postStayDTOList;
    }
}
