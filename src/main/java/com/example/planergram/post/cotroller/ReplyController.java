package com.example.planergram.post.cotroller;

import com.example.planergram.DTO.ResponseDTO;
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
            ReplyDTO replyDTO = replyService.writeReply(userId, postId, contents);
            return ResponseEntity.ok(replyDTO);
        } catch (Exception e) {
            log.error("댓글 작성에 실패했습니다 : " + e.getStackTrace());
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity.badRequest().body(responseDTO);
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
            ReplyDTO newReplyDTO = replyService.rewriteReply(replyId, contents);
            return ResponseEntity.ok(newReplyDTO);
        } catch (Exception e) {
            log.error("댓글수정이 실패하였습니다." + e.getMessage());
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }

    @DeleteMapping("/{replyId}")
    public ResponseEntity<?> delete(@PathVariable Long replyId) {
        try {
            List<ReplyDTO> replyDTOList = replyService.delete(replyId);
            return ResponseEntity.ok(replyDTOList);
        } catch (Exception e) {
            log.error("댓글삭제를 실패하였습니다." + e.getMessage());
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }
}