package com.example.planergram.postTravel.service;

import com.example.planergram.postTravel.DTO.PostTrainDTO;
import com.example.planergram.post.model.Post;
import com.example.planergram.postTravel.model.PostTrain;
import com.example.planergram.post.repository.PostRepository;
import com.example.planergram.postTravel.repository.PostTrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostTrainService {

    @Autowired
    private PostTrainRepository postTrainRepository;

    @Autowired
    private PostRepository postRepository;

    public String clickTrainLike(Long postId, PostTrainDTO postTrainDTO) {

        Post post = postRepository.getById(postId);
        int trainno = postTrainDTO.getTrainno();

        PostTrain postTrain = postTrainRepository.findByPostAndTrainno(post, trainno);
        if (postTrain == null) {
            return likeClick(post, postTrainDTO);
        }
        return likeCancel(postTrain);
    }

    private String likeClick(Post post, PostTrainDTO postTrainDTO) {
        PostTrain postTrain = PostTrain.builder()
                .post(post)
                .depplacename(postTrainDTO.getDepplacename())
                .arrplacename(postTrainDTO.getArrplacename())
                .depplandtime(postTrainDTO.getDepplandtime())
                .arrplandtime(postTrainDTO.getArrplandtime())
                .depplaceNodeName(postTrainDTO.getDepplacename())
                .depplaceNodeName(postTrainDTO.getDepplaceNodeName())
                .adultcharge(postTrainDTO.getAdultcharge())
                .trainno(postTrainDTO.getTrainno())
                .build();
        postTrainRepository.save(postTrain);
        return "기차정보 추가가 완료되었습니다.";
    }

    private String likeCancel(PostTrain postTrain) {
        postTrainRepository.delete(postTrain);
        return "기차정보가 삭제되었습니다.";
    }

    public List<PostTrainDTO> findByPost(Long postId) {
        Post post = postRepository.getById(postId);
        List<PostTrain> postTrainList = postTrainRepository.findByPost(post);
        return makePostTrainDTOList(postTrainList);
    }

    public PostTrainDTO findById(Long id) {
        PostTrain postTrain = postTrainRepository.getById(id);
        return makePostTrainDTO(postTrain);
    }

    static public PostTrainDTO makePostTrainDTO(PostTrain postTrain) {
        return PostTrainDTO.builder()
                .postTrainId(postTrain.getPostTrainId())
                .postId(postTrain.getPost().getPostId())
                .depplacename(postTrain.getDepplacename())
                .arrplacename(postTrain.getArrplacename())
                .arrplaceNodeName(postTrain.getArrplaceNodeName())
                .depplaceNodeName(postTrain.getDepplaceNodeName())
                .arrplandtime(postTrain.getArrplandtime())
                .depplandtime(postTrain.getDepplandtime())
                .adultcharge(postTrain.getAdultcharge())
                .trainno(postTrain.getTrainno())
                .build();
    }

    static public List<PostTrainDTO> makePostTrainDTOList(List<PostTrain> PostTrainList) {
        List<PostTrainDTO> postTrainDTOList = new ArrayList<>();
        for (PostTrain postTrain : PostTrainList) {
            postTrainDTOList.add(makePostTrainDTO(postTrain));
        }
        return postTrainDTOList;
    }
}
