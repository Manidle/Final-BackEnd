package com.example.planergram.post.cotroller;


import com.example.planergram.DTO.ResponseDTO;
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
            PostDTO newPostDTO = postService.save(postDTO);
            return ResponseEntity.ok(newPostDTO);
        } catch (Exception e) {
            log.error("게시글 작성에 실패했습니다 : " + e.getStackTrace());
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity.badRequest().body(responseDTO);
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
            PostDTO newPostDTO = postService.update(id,postDTO);
            return ResponseEntity.ok(newPostDTO);
        } catch (Exception e) {
            log.error("게시글 업데이트를 실패하였습니다." + e.getMessage());
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }

    //게시글 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            PostDTO newPostDTO = postService.delete(id);
            return ResponseEntity.ok(newPostDTO);
        } catch (Exception e) {
            log.error("게시글 삭제를 실패하였습니다." + e.getMessage());
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }
}