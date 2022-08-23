package com.example.planergram.controller;

import com.example.planergram.model.Board;
import com.example.planergram.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class BoardController {

    @Autowired
    private BoardService boardService;

    @PostMapping("/board/posting")
    public String posting(Board board){
        boardService.posting(board);
        return "글쓰기가 완료되었습니다.";
    }

    @GetMapping("/board/findall")
    public List<Board> findAll() {
        return boardService.findAll();
    }

    @DeleteMapping("/board/delete/{id}")
    public List<Board> delete(@PathVariable int id){
        return boardService.delete(id);
    };

    @PutMapping("/board/posting/{id}")
    public List<Board> update(@PathVariable int id ,@RequestBody Board board) {
        boardService.update(id,board);
        return boardService.update(id,board);
    }
}