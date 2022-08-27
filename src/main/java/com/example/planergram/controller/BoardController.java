package com.example.planergram.controller;

import com.example.planergram.DTO.BoardDTO;
import com.example.planergram.DTO.ResponseDTO;
import com.example.planergram.model.Board;
import com.example.planergram.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class BoardController {

    @Autowired
    private BoardService boardService;

//    @PostMapping("/board/posting")
//    public String posting(Board board) {
//        boardService.posting(board);
//        return "게시판 생성완료!";
//    }

    @PostMapping("/board/posting")
    public ResponseEntity<?> save(@RequestBody BoardDTO boardDTO) {
        try {
            Board newBoard = boardService.save(boardDTO);
            BoardDTO newBoardDTO = boardService.makeBoardDTO(newBoard);
            return ResponseEntity.ok(newBoardDTO);
        } catch (Exception e) {
            log.error("게시판 등록 Fail : " + e.getStackTrace());
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }



    @GetMapping("/board/findall")
    public List<Board> findAll() {
        return boardService.findAll();
    }

    @DeleteMapping("/board/delete/{id}")
    public List<Board> delete(@PathVariable int id) {
        return boardService.delete(id);
    }


    @PutMapping("/board/posting/{id}")
    public List<Board> update(@PathVariable int id, @RequestBody Board board) {
        boardService.update(id, board);
        return boardService.update(id, board);
    }
}