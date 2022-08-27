package com.example.planergram.service;

import com.example.planergram.DTO.BoardDTO;
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

    public String posting(Board board) {
        boardRepository.save(board);
        return "게시판 작성완료!";
    }

    public Board save(BoardDTO boardDTO) throws Exception {
        Board newDanger = Board
                .builder()
                .id(boardDTO.getBoardId())
                .title(boardDTO.getTitle())
                .img(boardDTO.getImg())
                .build();
        return boardRepository.save(newDanger);
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
            newboard.setImg(board.getImg());
            boardRepository.save(newboard);
        });
        return boardRepository.findAll();
    }

    public BoardDTO makeBoardDTO(Board board) {
        return BoardDTO
                .builder()
                .boardId(board.getId())
                .title(board.getTitle())
                .img(board.getImg())
                .build();
    }
}