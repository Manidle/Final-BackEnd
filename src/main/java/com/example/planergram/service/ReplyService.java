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

    public ReplyDTO makeReplyDTO(Reply reply){
        return ReplyDTO.builder()
                .replyId(reply.getReplyId())
                .contents(reply.getContents())
                .postId(reply.getPost().getPostId())
                .userId(reply.getUser().getUserId())
                .build();
    }
}
