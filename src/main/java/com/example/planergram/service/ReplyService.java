package com.example.planergram.service;

import com.example.planergram.DTO.ReplyDTO;
import com.example.planergram.model.Post;
import com.example.planergram.model.Reply;
import com.example.planergram.model.User;
import com.example.planergram.repository.PostRepository;
import com.example.planergram.repository.ReplyRepository;
import com.example.planergram.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReplyService {
    @Autowired
    private ReplyRepository replyRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    public ReplyDTO writeReply(Long userId, Long postId, String contents) {
        User user = userRepository.getById(userId);
        Post post = postRepository.getById(postId);
        Reply reply = Reply.builder()
                .contents(contents)
                .user(user)
                .post(post)
                .build();
        reply = replyRepository.save(reply);
        return makeReplyDTO(reply);
    }

    public ReplyDTO rewriteReply(Long replyId, String contents) {
        Reply reply = replyRepository.getById(replyId);
        reply.setContents(contents);
        reply = replyRepository.save(reply);
        return makeReplyDTO(reply);
    }

    public List<ReplyDTO> findReplyByPostId(Long postId){
        Post post = postRepository.getById(postId);
        List<Reply> replyList = replyRepository.findByPost(post);
        List<ReplyDTO> replyDTOList = new ArrayList<>();
        for (Reply reply: replyList){
            replyDTOList.add(makeReplyDTO(reply));
        }
        return replyDTOList;
    }

    public List<ReplyDTO> delete(Long replyId){
        Reply reply =  replyRepository.getById(replyId);
        Long postId = reply.getPost().getPostId();
        replyRepository.delete(reply);
        return findReplyByPostId(postId);
    }

    public ReplyDTO makeReplyDTO(Reply reply){
        return ReplyDTO.builder()
                .replyId(reply.getReplyId())
                .contents(reply.getContents())
                .postId(reply.getPost().getPostId())
                .userId(reply.getUser().getUserId())
                .build();
    }
}
