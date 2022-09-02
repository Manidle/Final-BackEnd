package com.example.planergram.controller;


import com.example.planergram.DTO.PostDTO;
import com.example.planergram.DTO.ResponseDTO;
import com.example.planergram.model.Post;
import com.example.planergram.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class PostController {

    @Autowired
    private PostService postService;

    // 게시글 작성
    @PostMapping("/post/posting")
    public ResponseEntity<?> save(@RequestBody PostDTO postDTO) {
        try {
            Post newPost = postService.save(postDTO);
            PostDTO newPostDTO = postService.makePostDTO(newPost);
            return ResponseEntity.ok(newPostDTO);
        } catch (Exception e) {
            log.error("게시글 작성에 실패했습니다 : " + e.getStackTrace());
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }

    // 게시글 조회
    @GetMapping("/post")
    public ResponseEntity<?> findAll() {
        List<Post> postList = postService.findAll();
        if (postList.size() == 0) {
            log.error("게시글이 없습니다.");
            ResponseDTO responseDTO = ResponseDTO.builder().error("게시글이 없습니다.").build();
            return ResponseEntity.badRequest().body(responseDTO);
        }
        List<PostDTO> postDTOList = postService.makePostDTOList(postList);
        return ResponseEntity.ok(postDTOList);
    }

    //게시글 업데이트
    @PutMapping("/post/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id,@RequestBody PostDTO updatePostDTO) {
        try {
            Post newPost = postService.update(id,updatePostDTO);
            PostDTO postDTO = postService.makePostDTO(newPost);
            return ResponseEntity.ok(postDTO);
        } catch (Exception e) {
            log.error("게시글 업데이트를 실패하였습니다." + e.getMessage());
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }

    //게시글 삭제
    @DeleteMapping("/post/{id}")
    public List<Post> delete(@PathVariable Long id) {
        return postService.delete(id);
    }
}