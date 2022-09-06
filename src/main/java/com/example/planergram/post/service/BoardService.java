package com.example.planergram.post.service;

import com.example.planergram.post.DTO.BoardDTO;
import com.example.planergram.post.model.Board;
import com.example.planergram.post.model.Post;
import com.example.planergram.post.repository.BoardRepository;
import com.example.planergram.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private PostRepository postRepository;

    public BoardDTO save(BoardDTO boardDTO) {
        Board board = makeBoard(boardDTO);
        board = boardRepository.save(board);
        return makeBoardDTO(board);
    }

    public List<BoardDTO> findAll() {
        List<Board> BoardList = boardRepository.findAll();
        List<BoardDTO> boardDTOList = new ArrayList<>();
        for (Board board: BoardList) {
            boardDTOList.add(makeBoardDTO(board));
        }
        return boardDTOList;
    }

    public BoardDTO update(Long id,BoardDTO boardDTO){
        Board board = boardRepository.getById(id);
        board.setTitle(boardDTO.getBoardTitle());
        board.setImg(boardDTO.getImg());
        board = boardRepository.save(board);
        return makeBoardDTO(board);
    }

    public BoardDTO delete(Long id){
        Board board = boardRepository.getById(id);
        boardRepository.delete(board);
        return makeBoardDTO(board);
    }

    public BoardDTO makeBoardDTO(Board board) {
        List<Long> postDTOList = new ArrayList<>();
        if (board.getPostList() != null){
            for (Post post : board.getPostList()) {
                postDTOList.add(post.getPostId());
            }
        }
        return BoardDTO
                .builder()
                .boardId(board.getBoardId())
                .boardTitle(board.getTitle())
                .img(board.getImg())
                .postDTOList(postDTOList)
                .build();
    }

    public Board makeBoard(BoardDTO boardDTO) {
        List<Post> postList = new ArrayList<>();
        if (boardDTO.getPostDTOList() != null){
            for (Long postId: boardDTO.getPostDTOList()) {
                postList.add(postRepository.getById(postId));
            }
        }
        return Board
                .builder()
                .boardId(boardDTO.getBoardId())
                .title(boardDTO.getBoardTitle())
                .img(boardDTO.getImg())
                .postList(postList)
                .build();
    }
}