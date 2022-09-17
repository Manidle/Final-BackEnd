package com.example.planergram.post.cotroller;


import com.example.planergram.Response.ResponseDTO;
import com.example.planergram.Response.ResponseService;
import com.example.planergram.config.auth.PrincipalDetails;
import com.example.planergram.post.DTO.PostDTO;
import com.example.planergram.post.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/auth/v1")
public class PostController {

    private final String POST = "/post";
    private final String BOARD = "/board";
    private final String ID = "/{id}";

    @Autowired
    private PostService postService;

    // 게시글 작성
    @PostMapping(BOARD + "/{boardId}" + POST)
    public ResponseEntity<?> save(@AuthenticationPrincipal PrincipalDetails principalDetails,
                                  @PathVariable Long boardId,
                                  @RequestBody PostDTO postDTO) {
        try {
            log.info(principalDetails.getUsername());
            postDTO.setUserId(principalDetails.getUser().getUserId());
            postDTO.setBoardId(boardId);
            return ResponseEntity.ok(postService.save(postDTO));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("게시글 등록이 실패되었습니다",e);
        }
    }

    // 게시글 조회
    @GetMapping(POST)
    public ResponseEntity<?> findAll() {
        List<PostDTO> postDTOList = postService.findAll();
        if (postDTOList.size() == 0) {
            log.error("게시글이 없습니다.");
            ResponseDTO responseDTO = ResponseDTO.builder().error("게시글이 없습니다.").build();
            return ResponseEntity.badRequest().body(responseDTO);
        }
        return ResponseEntity.ok(postDTOList);
    }

    // 게시글 조회
    @GetMapping(POST + ID)
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(postService.findById(id));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("게시글이 없습니다.",e);
        }
    }

    //게시글 업데이트
    @PatchMapping(POST + ID)
    public ResponseEntity<?> update(@AuthenticationPrincipal PrincipalDetails principalDetails, @PathVariable Long id,@RequestBody PostDTO postDTO) {
        try {
            return ResponseEntity.ok(postService.update(principalDetails.getUser(),id,postDTO));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("게시글 수정에 실패되었습니다",e);
        }
    }

    //게시글 삭제
    @DeleteMapping(POST + ID)
    public ResponseEntity<?> delete(@AuthenticationPrincipal PrincipalDetails principalDetails, @PathVariable Long id) {
        try {
            return ResponseEntity.ok(postService.delete(principalDetails.getUser(),id));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("게시글 삭제에 실패되었습니다",e);
        }
    }
}