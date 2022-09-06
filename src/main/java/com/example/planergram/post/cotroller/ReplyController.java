package com.example.planergram.post.cotroller;

import com.example.planergram.Response.ResponseDTO;
import com.example.planergram.Response.ResponseService;
import com.example.planergram.post.DTO.ReplyDTO;
import com.example.planergram.post.service.ReplyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reply")
@Slf4j
public class ReplyController {

    @Autowired
    private ReplyService replyService;

    @GetMapping
    public ResponseEntity<?> writeReply(
            @RequestParam(value = "user") Long userId,
            @RequestParam(value = "post") Long postId,
            @RequestParam(value = "contents") String contents) {
        try {
            return ResponseEntity.ok(replyService.writeReply(userId, postId, contents));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("댓글 작성에 실패했습니다.",e);
        }
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<?> findReplyByPostId(@PathVariable Long postId) {
        List<ReplyDTO> replyDTOList = replyService.findReplyByPostId(postId);
        if (replyDTOList.size() == 0) {
            log.error("댓글이 없습니다.");
            ResponseDTO responseDTO = ResponseDTO.builder().error("댓글이 없습니다.").build();
            return ResponseEntity.badRequest().body(responseDTO);
        }
        return ResponseEntity.ok(replyDTOList);
    }

    @PatchMapping
    public ResponseEntity<?> rewriteReply(@RequestParam(value = "replyId") Long replyId,
                                          @RequestParam(value = "contents") String contents) {
        try {
            return ResponseEntity.ok(replyService.rewriteReply(replyId, contents));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("댓글 수정에 실패했습니다.",e);
        }
    }

    @DeleteMapping("/{replyId}")
    public ResponseEntity<?> delete(@PathVariable Long replyId) {
        try {
            return ResponseEntity.ok(replyService.delete(replyId));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("댓글 삭제에 실패하였습니다.",e);
        }
    }
}