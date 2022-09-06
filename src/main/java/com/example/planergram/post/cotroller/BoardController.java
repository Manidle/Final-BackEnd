package com.example.planergram.post.cotroller;

import com.example.planergram.Response.ResponseService;
import com.example.planergram.post.DTO.BoardDTO;
import com.example.planergram.post.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    // 게시판 등록
    @PostMapping
    public ResponseEntity<?> save(@RequestBody BoardDTO boardDTO) {
        try {
            return ResponseEntity.ok(boardService.save(boardDTO));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("게시판 등록에 실패했습니다.", e);
        }
    }

    // 게시판 조회
    @GetMapping
    public ResponseEntity<?> findAll() {
        try {
            return ResponseEntity.ok(boardService.findAll());
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("게시판조회에 실패했습니다.", e);
        }
    }

    // 게시판 업데이트
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody BoardDTO updateBoarDTO) {
        try {
            return ResponseEntity.ok(boardService.update(id, updateBoarDTO));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("게시판수정에 실패했습니다.",e);
        }
    }

    // 게시판 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(boardService.delete(id));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("게시판조회에 실패했습니다.",e);
        }
    }
}