package com.example.planergram.post.cotroller;


import com.example.planergram.Response.ResponseDTO;
import com.example.planergram.Response.ResponseService;
import com.example.planergram.post.DTO.PostDTO;
import com.example.planergram.post.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    // 게시글 작성
    @PostMapping
    public ResponseEntity<?> save(@RequestBody PostDTO postDTO) {
        try {
            return ResponseEntity.ok(postService.save(postDTO));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("게시글 등록이 실패되었습니다",e);
        }
    }

    // 게시글 조회
    @GetMapping
    public ResponseEntity<?> findAll() {
        List<PostDTO> postDTOList = postService.findAll();
        if (postDTOList.size() == 0) {
            log.error("게시글이 없습니다.");
            ResponseDTO responseDTO = ResponseDTO.builder().error("게시글이 없습니다.").build();
            return ResponseEntity.badRequest().body(responseDTO);
        }
        return ResponseEntity.ok(postDTOList);
    }

    //게시글 업데이트
    @PatchMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody PostDTO postDTO) {
        try {
            return ResponseEntity.ok(postService.update(id,postDTO));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("게시글 수정에 실패되었습니다",e);
        }
    }

    //게시글 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(postService.delete(id));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("게시글 삭제에 실패되었습니다",e);
        }
    }
}