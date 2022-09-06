package com.example.planergram.post.cotroller;

import com.example.planergram.DTO.ResponseDTO;
import com.example.planergram.post.DTO.BoardDTO;
import com.example.planergram.post.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
            BoardDTO newBoardDTO = boardService.save(boardDTO);
            return ResponseEntity.ok(newBoardDTO);
        } catch (Exception e) {
            log.error("게시판 등록에 실패했습니다." + e.getStackTrace());
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }

    // 게시판 조회
    @GetMapping
    public ResponseEntity<?> findAll() {
        try {
            List<BoardDTO> boardDTOList = boardService.findAll();
            return ResponseEntity.ok(boardDTOList);
        } catch (Exception e) {
            log.error("게시판 등록에 실패했습니다." + e.getStackTrace());
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }

    // 게시판 업데이트
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody BoardDTO updateBoarDTO) {
        try {
            BoardDTO boardDTO = boardService.update(id,updateBoarDTO);
            return ResponseEntity.ok(boardDTO);
        } catch (Exception e) {
            log.error("게시판 변경에 실패하였습니다. :" + e.getMessage());
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }

    // 게시판 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            BoardDTO boardDTO = boardService.delete(id);
            return ResponseEntity.ok(boardDTO);
            }catch (Exception e) {
            log.error("게시판 삭제를 실패하였습니다: " + e.getMessage());
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }
}