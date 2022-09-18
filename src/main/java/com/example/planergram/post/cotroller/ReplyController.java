package com.example.planergram.post.cotroller;

import com.example.planergram.Response.ResponseDTO;
import com.example.planergram.Response.ResponseService;
import com.example.planergram.config.auth.PrincipalDetails;
import com.example.planergram.post.DTO.ReplyDTO;
import com.example.planergram.post.service.ReplyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("api")
@Api(tags = {"댓글에 대한 API 정보를 제공하는 Controller"})
public class ReplyController {

    @Autowired
    private ReplyService replyService;

    private final String VERSION = "/v1";
    private final String AUTH = "/auth" + VERSION;

    private final String REPLY = "/reply";

    @GetMapping(AUTH + REPLY + "/register")
    @ApiOperation(value = "USER : 해당 게시글에 댓글을 작성하는 API")
    public ResponseEntity<?> writeReply(
            @AuthenticationPrincipal PrincipalDetails principalDetails,
            @ApiParam(value = "게시글의 ID값") @RequestParam(value = "post") Long postId,
            @RequestParam(value = "contents") String contents) {
        try {
            return ResponseEntity.ok(replyService.writeReply(principalDetails.getUser().getUserId(), postId, contents));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("댓글 작성에 실패했습니다.",e);
        }
    }

    @GetMapping(AUTH + REPLY + "/post/{postId}")
    @ApiOperation(value = "USER : 해당 게시글에 댓글들을 조회하는 API")
    public ResponseEntity<?> findReplyByPostId(@ApiParam(value = "게시글의 ID값") @PathVariable Long postId) {
        List<ReplyDTO> replyDTOList = replyService.findReplyByPostId(postId);
        if (replyDTOList.size() == 0) {
            log.error("댓글이 없습니다.");
            ResponseDTO responseDTO = ResponseDTO.builder().error("댓글이 없습니다.").build();
            return ResponseEntity.badRequest().body(responseDTO);
        }
        return ResponseEntity.ok(replyDTOList);
    }

    @PatchMapping(AUTH + REPLY + "/modify")
    @ApiOperation(value = "USER : 해당 댓글의 내용을 수정하는 API")
    public ResponseEntity<?> rewriteReply(@AuthenticationPrincipal PrincipalDetails principalDetails,
                                          @ApiParam(value = "댓글의 ID값") @RequestParam(value = "replyId") Long replyId,
                                          @ApiParam(value = "댓글의 바뀐 내용")@RequestParam(value = "contents") String contents) {
        try {
            return ResponseEntity.ok(replyService.rewriteReply(principalDetails.getUser(), replyId, contents));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("댓글 수정에 실패했습니다.",e);
        }
    }

    @DeleteMapping(AUTH + REPLY + "/{replyId}")
    @ApiOperation(value = "USER : 해당 댓글을 삭제하는 API")
    public ResponseEntity<?> delete(@AuthenticationPrincipal PrincipalDetails principalDetails,
                                    @ApiParam(value = "댓글의 ID값") @PathVariable Long replyId) {
        try {
            return ResponseEntity.ok(replyService.delete(principalDetails.getUser(), replyId));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("댓글 삭제에 실패하였습니다.",e);
        }
    }
}