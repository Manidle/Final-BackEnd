package com.example.planergram.controller;

import com.example.planergram.DTO.ReplyDTO;
import com.example.planergram.service.ReplyService;
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
}
