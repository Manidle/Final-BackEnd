package com.example.planergram.post.service;

import com.example.planergram.post.DTO.ReplyDTO;
import com.example.planergram.post.model.Post;
import com.example.planergram.post.model.Reply;
import com.example.planergram.user.model.User;
import com.example.planergram.post.repository.PostRepository;
import com.example.planergram.post.repository.ReplyRepository;
import com.example.planergram.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
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
                .nickName(user.getNickname())
                .build();
        reply = replyRepository.save(reply);
        log.info("댓글작성이 완료되었습니다.");
        return makeReplyDTO(reply);
    }

    public ReplyDTO rewriteReply(User user, Long replyId, String contents) throws Exception {
        Reply reply = replyRepository.getById(replyId);
        if (!user.getUserId().equals(reply.getUser().getUserId())) {
            throw new Exception("작성한 유저가 일치하지 않습니다.");
        }
        reply.setContents(contents);
        reply = replyRepository.save(reply);
        log.info("댓글 수정이 완료되었습니다");
        return makeReplyDTO(reply);
    }

    public List<ReplyDTO> findReplyByPostId(Long postId) {
        Post post = postRepository.getById(postId);
        List<Reply> replyList = replyRepository.findByPost(post);
        List<ReplyDTO> replyDTOList = new ArrayList<>();
        for (Reply reply : replyList) {
            replyDTOList.add(makeReplyDTO(reply));
        }
        log.info("해당 게시글에 댓글들이 조회되었습니다.");
        return replyDTOList;
    }

    public List<ReplyDTO> delete(User user, Long replyId) throws Exception {
        Reply reply = replyRepository.getById(replyId);
        if (!user.getUserId().equals(reply.getUser().getUserId())) {
            throw new Exception("작성한 유저가 일치하지 않습니다.");
        }
        Long postId = reply.getPost().getPostId();
        replyRepository.delete(reply);
        log.info("댓글 삭제가 완료되었습니다.");
        return findReplyByPostId(postId);
    }

    static public ReplyDTO makeReplyDTO(Reply reply) {
        return ReplyDTO.builder()
                .replyId(reply.getReplyId())
                .contents(reply.getContents())
                .postId(reply.getPost().getPostId())
                .userId(reply.getUser().getUserId())
                .nickName(reply.getNickName())
                .build();
    }
}
