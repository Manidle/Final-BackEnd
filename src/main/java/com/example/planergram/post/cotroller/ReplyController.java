package com.example.planergram.post.cotroller;

import com.example.planergram.post.DTO.ReplyDTO;
import com.example.planergram.post.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReplyController {

    @Autowired
    private ReplyService replyService;

    @GetMapping("/reply")
    public ReplyDTO writeReply(
            @RequestParam(value = "user") Long userId,
            @RequestParam(value = "post") Long postId,
            @RequestParam(value = "contents") String contents)
    {
        return replyService.writeReply(userId,postId, contents);
    }

    @PatchMapping("/reply")
    public ReplyDTO rewriteReply(@RequestParam(value = "replyId") Long replyId,
                                 @RequestParam(value = "contents") String contents){
        return replyService.rewriteReply(replyId,contents);
    }

    @GetMapping("reply/post/{postId}")
    public List<ReplyDTO> findReplyByPostId(@PathVariable Long postId){
        return replyService.findReplyByPostId(postId);
    }

    @DeleteMapping("reply/{replyId}")
    public List<ReplyDTO> delete(@PathVariable Long replyId){
        return replyService.delete(replyId);
    }
}