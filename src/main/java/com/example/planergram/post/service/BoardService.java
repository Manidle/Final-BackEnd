package com.example.planergram.post.service;

import com.example.planergram.post.DTO.BoardDTO;
import com.example.planergram.post.model.Board;
import com.example.planergram.post.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    // 게시판생성
    public Board save(BoardDTO boardDTO) throws Exception {
        Board board = makeBoard(boardDTO);
        return boardRepository.save(board);
    }

    // 게시판 조회
    public List<Board> findAll() {
        return boardRepository.findAll();
    }

    public Board update(Long id,BoardDTO boardDTO) throws Exception {
        Board findBoard = boardRepository.findById(id).orElseThrow(Exception::new);
        findBoard.setTitle(boardDTO.getBoardTitle());
        findBoard.setImg(boardDTO.getImg());
        return boardRepository.save(findBoard);
    }

    public Board delete(Long id) throws Exception {
        final Board board = boardRepository.findById(id).orElseThrow(Exception::new);
        boardRepository.delete(board);
        return board;
    }

    //make
    public BoardDTO makeBoardDTO(Board board) {
        return BoardDTO
                .builder()
                .boardId(board.getBoardId())
                .boardTitle(board.getTitle())
                .img(board.getImg())
                .build();
    }

    public Board makeBoard(BoardDTO boardDTO) {
        return Board
                .builder()
                .boardId(boardDTO.getBoardId())
                .title(boardDTO.getBoardTitle())
                .img(boardDTO.getImg())
                .build();
    }

}