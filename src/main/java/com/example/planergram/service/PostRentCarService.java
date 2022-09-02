package com.example.planergram.service;

import com.example.planergram.DTO.PostRentCarDTO;
import com.example.planergram.model.Post;
import com.example.planergram.model.PostRentCar;
import com.example.planergram.model.RentCar;
import com.example.planergram.repository.PostRentCarRepository;
import com.example.planergram.repository.PostRepository;
import com.example.planergram.repository.RentCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<PostRentCarDTO> findByPost(Long postId) {
        Post post = postRepository.getById(postId);
        List<PostRentCar> postRentCarList = postRentCarRepository.findByPost(post);
        return makePostRentCarDTOList(postRentCarList);
    }




    private PostRentCarDTO makePostRentCarDTO(PostRentCar postRentCar){
        return PostRentCarDTO
                .builder()
                .postRentCarId(postRentCar.getPostRentCarId())
                .postId(postRentCar.getPost().getPostId())
                .rentCarId(postRentCar.getRentCar().getRentCarId())
                .build();
    }

    private List<PostRentCarDTO> makePostRentCarDTOList(List<PostRentCar> postRentCarList){
        List<PostRentCarDTO> postRentCarDTOList = new ArrayList<>();
        for (PostRentCar postRentCar: postRentCarList){
            postRentCarDTOList.add(makePostRentCarDTO(postRentCar));
        }
        return postRentCarDTOList;
    }


}
