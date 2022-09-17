package com.example.planergram.post.cotroller;

import com.example.planergram.Response.ResponseService;
import com.example.planergram.post.DTO.BoardDTO;
import com.example.planergram.post.service.BoardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("api")
@Api(tags = {"게시판에 대한 API 정보를 제공하는 Controller"})
public class BoardController {

    @Autowired
    private BoardService boardService;

    private final String VERSION = "/v1";
    private final String AUTH = "/auth" + VERSION;
    private final String ADMIN_AUTH = "/admin" + AUTH + VERSION;
    private final String BOARD = "/board";

    // 게시판 등록
    @ApiOperation(value = "ADMIN : 게시판 생성 API")
    @PostMapping(ADMIN_AUTH + BOARD)
    public ResponseEntity<?> save(@RequestBody BoardDTO boardDTO) {
        try {
            return ResponseEntity.ok(boardService.save(boardDTO));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("게시판 등록에 실패했습니다.", e);
        }
    }

    // 게시판 조회
    @ApiOperation(value = "ALL : 게시판 전체 조회 API")
    @GetMapping(BOARD)
    public ResponseEntity<?> findAll() {
        try {
            return ResponseEntity.ok(boardService.findAll());
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("게시판조회에 실패했습니다.", e);
        }
    }
    @ApiOperation(value = "USER : 게시판 ID로 조회 API")
    @GetMapping(AUTH + BOARD + "/{id}")
    public ResponseEntity<?> findById(@ApiParam(value = "게시판의 ID값") @PathVariable Long id) {
        try {
            return ResponseEntity.ok(boardService.findById(id));
        } catch (Exception e){
            return ResponseService.makeResponseEntity("유저 정보 조회에 실패했습니다.",e);
        }
    }

    // 게시판 업데이트
    @ApiOperation(value = "ADMIN : 게시판 업데이트 API")
    @PutMapping(ADMIN_AUTH + BOARD + "/{id}")
    public ResponseEntity<?> update(@ApiParam(value = "게시판의 ID값") @PathVariable Long id, @RequestBody BoardDTO updateBoarDTO) {
        try {
            return ResponseEntity.ok(boardService.update(id, updateBoarDTO));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("게시판수정에 실패했습니다.",e);
        }
    }

    // 게시판 삭제
    @ApiOperation(value = "ADMIN : 게시판 삭제 API")
    @DeleteMapping(ADMIN_AUTH + BOARD + "/{id}")
    public ResponseEntity<?> delete(@ApiParam(value = "게시판의 ID값") @PathVariable Long id) {
        try {
            return ResponseEntity.ok(boardService.delete(id));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("게시판조회에 실패했습니다.",e);
        }
    }
}