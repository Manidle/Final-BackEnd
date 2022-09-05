package com.example.planergram.post.cotroller;

import com.example.planergram.post.DTO.BoardDTO;
import com.example.planergram.DTO.ResponseDTO;
import com.example.planergram.post.model.Board;
import com.example.planergram.post.model.Post;
import com.example.planergram.post.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
            Board newBoard = boardService.save(boardDTO);
            BoardDTO newBoardDTO = boardService.makeBoardDTO(newBoard);
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
        List<Board> boardList = boardService.findAll();
        List<BoardDTO> boardDTOList = new ArrayList<>();
        for (Board board : boardList) {
            List<Long> postDTOList = new ArrayList<>();
            for (Post post : board.getPostList()) {
                postDTOList.add(post.getPostId());
            }
            boardDTOList.add(
                    BoardDTO
                            .builder()
                            .boardId(board.getBoardId())
                            .boardTitle(board.getTitle())
                            .img(board.getImg())
                            .postDTOList(postDTOList)
                            .build()
            );
        }
        return ResponseEntity.ok(boardDTOList);
    }

    // 게시판 업데이트
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody BoardDTO updateBoarDTO) {
        try {
            Board newBoard = boardService.update(id, updateBoarDTO);
            List<Long> postDTOList = new ArrayList<>();
            for (Post post : newBoard.getPostList()) {
                postDTOList.add(post.getPostId());
            }
            BoardDTO boardDTO = boardService.makeBoardDTO(newBoard);
            return ResponseEntity.ok(boardDTO);
        } catch (Exception e) {
            log.error("게시판 변경 Fail :" + e.getMessage());
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }

    // 게시판 삭제
    @DeleteMapping
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        try {
            Board newBoard = boardService.delete(id);
            List<Long> postList = new ArrayList<>();
            for (Post post : newBoard.getPostList()) {
                postList.add(post.getPostId());
            }
            BoardDTO boardDTO = boardService.makeBoardDTO(newBoard);
            return ResponseEntity.ok(boardDTO);
        } catch (Exception e) {
            log.error("고위험군 환자 정보 삭제에 실패했습니다. :" + e.getMessage());
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }
}