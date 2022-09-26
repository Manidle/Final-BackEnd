package com.example.planergram.post.service;

import com.example.planergram.post.DTO.BoardDTO;
import com.example.planergram.post.model.Board;
import com.example.planergram.post.model.Post;
import com.example.planergram.post.repository.BoardRepository;
import com.example.planergram.post.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private PostRepository postRepository;

    public BoardDTO save(BoardDTO boardDTO) throws Exception {
        try {
            Board board = makeBoard(boardDTO);
            board = boardRepository.save(board);
            log.info("게시판 생성완료");
            return makeBoardDTO(board);
        } catch (Exception e) {
            throw new Exception("중복된 정보로는 게시판을 만들 수 없습니다.");
        }
    }

    public List<BoardDTO> findAll() {
        List<Board> BoardList = boardRepository.findAll();
        List<BoardDTO> boardDTOList = new ArrayList<>();
        for (Board board : BoardList) {
            boardDTOList.add(makeBoardDTO(board));
        }
        log.info("게시판을 모두 조회하였습니다.");
        return boardDTOList;
    }

    public BoardDTO update(Long id, BoardDTO boardDTO) {
        Board board = boardRepository.getById(id);
        board.setBoardName(boardDTO.getBoardName());
        board = boardRepository.save(board);
        log.info("게시판 이름이 변경되었습니다.");
        return makeBoardDTO(board);
    }

    public BoardDTO delete(Long id) {
        Board board = boardRepository.getById(id);
        boardRepository.delete(board);
        log.info("게시판이 삭제되었습니다.");
        return makeBoardDTO(board);
    }

    public BoardDTO findById(Long id) {
        Board board = boardRepository.getById(id);
        return makeBoardDTO(board);
    }

    public BoardDTO makeBoardDTO(Board board) {
        List<Long> postDTOList = new ArrayList<>();
        if (board.getPostList() != null) {
            for (Post post : board.getPostList()) {
                postDTOList.add(post.getPostId());
            }
        }
        return BoardDTO
                .builder()
                .boardId(board.getBoardId())
                .boardName(board.getBoardName())
                .postDTOList(postDTOList)
                .build();
    }

    public Board makeBoard(BoardDTO boardDTO) {
        List<Post> postList = new ArrayList<>();
        if (boardDTO.getPostDTOList() != null) {
            for (Long postId : boardDTO.getPostDTOList()) {
                postList.add(postRepository.getById(postId));
            }
        }
        return Board
                .builder()
                .boardId(boardDTO.getBoardId())
                .boardName(boardDTO.getBoardName())
                .postList(postList)
                .build();
    }
}