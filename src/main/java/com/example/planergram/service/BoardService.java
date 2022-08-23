package com.example.planergram.service;

import com.example.planergram.model.Board;
import com.example.planergram.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public String posting(Board board){
        boardRepository.save(board);
        return "글쓰기가 완료되었다!";
    }

    public List<Board> findAll() {
        return boardRepository.findAll();
    }

    public List<Board> delete(int id) {
        final Optional<Board> foundBoard = boardRepository.findById(id);
        foundBoard.ifPresent(board -> {
            boardRepository.delete(board);
        });
        return boardRepository.findAll();
    }

    public List<Board> update(int id, Board board) {

        final Optional<Board> foundBoard = boardRepository.findById(id);

        foundBoard.ifPresent(newboard -> {
            newboard.setTitle(board.getTitle());
            newboard.setContent(board.getContent());
            boardRepository.save(newboard);
        });

        return boardRepository.findAll();

    }
}