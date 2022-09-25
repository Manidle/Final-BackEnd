package com.example.planergram.post.cotroller;


import com.example.planergram.Response.ResponseDTO;
import com.example.planergram.Response.ResponseService;
import com.example.planergram.config.auth.PrincipalDetails;
import com.example.planergram.post.DTO.PostDTO;
import com.example.planergram.post.service.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@Api(tags = {"게시글에 대한 API 정보를 제공하는 Controller"})
@RequestMapping("/api")
public class PostController {

    private final String VERSION = "/v1";
    private final String AUTH = "/auth" + VERSION;
    private final String POST = "/post";
    private final String BOARD = "/board";
    private final String ID = "/{id}";

    @Autowired
    private PostService postService;

    @ApiOperation(value = "USER : 해당 게시판에 게시글을 작성하는 API")
    @PostMapping(AUTH + BOARD + "/{boardId}" + POST + "/register")
    public ResponseEntity<?> save(@AuthenticationPrincipal PrincipalDetails principalDetails,
                                  @ApiParam(value = "게시판의 ID값") @PathVariable Long boardId,
                                  @RequestBody PostDTO postDTO) {
        try {
            log.info(principalDetails.getUsername());
            postDTO.setUserId(principalDetails.getUser().getUserId());
            postDTO.setNickname(principalDetails.getUser().getNickname());
            postDTO.setBoardId(boardId);
            return ResponseEntity.ok(postService.save(postDTO));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("게시글 등록이 실패되었습니다",e);
        }
    }

    //게시판 ID로 filtering된 게시글 조회
    @ApiOperation(value = "게시판 ID로 filtering된 게시글 조회 API")
    @GetMapping(AUTH + POST + "/filter/{boardId}")
    public ResponseEntity<?> findByBoard(@PathVariable Long boardId) {
        try {
            return ResponseEntity.ok(postService.findByBoard(boardId));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("게시글이 없습니다.",e);
        }
    }

    //게시판 ID로 filtering된 게시글 조회된 채로 검색어 입력시 제목으로 필터링
    @ApiOperation(value = "게시판 ID로 filtering된 게시글 조회된 채로 검색어 입력시 제목으로 조회 API")
    @GetMapping(AUTH + POST + "/filter/board/title")
    public ResponseEntity<?> findByBoardAndTitleLike(@RequestParam(value = "BoardId") Long boardId,
                                                     @RequestParam(value = "title") String title) {
        try {
            return ResponseEntity.ok(postService.findByBoardAndTitleLike(boardId,title));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("게시글이 없습니다.",e);
        }
    }

    @ApiOperation(value = "USER : 게시글을 ID로 조회하는 API")
    @GetMapping(AUTH + POST + ID)
    public ResponseEntity<?> findById(@ApiParam(value = "게시글의 ID값") @PathVariable Long id) {
        try {
            return ResponseEntity.ok(postService.findById(id));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("게시글이 없습니다.",e);
        }
    }

    // HOT 게시글용 : 모든게시글을 좋아요 순으로 내림차순 정렬하여 상위5개만 출력
    @ApiOperation(value = "HOT게시글용 : 모든게시글을 좋아요 순으로 내림차순 정렬조회하는 API")
    @GetMapping("v1/filter/list/post/desc/top")
    public ResponseEntity<?> findTop5ByOrderByLikeCountDesc() {
        List<PostDTO> postDTOList = postService.findTop5ByOrderByLikeCountDesc();
        if (postDTOList.size() == 0) {
            log.error("게시글이 없습니다.");
            ResponseDTO responseDTO = ResponseDTO.builder().error("Hot 게시글이 없습니다.").build();
            return ResponseEntity.badRequest().body(responseDTO);
        }
        return ResponseEntity.ok(postDTOList);
    }

    //게시글 업데이트
    @ApiOperation(value = "USER : 게시글을 수정하는 API")
    @PutMapping(AUTH + POST + "/modify" + ID)
    public ResponseEntity<?> update(@AuthenticationPrincipal PrincipalDetails principalDetails,
                                    @ApiParam(value = "게시글의 ID값") @PathVariable Long id,
                                    @RequestBody PostDTO postDTO) {
        try {
            return ResponseEntity.ok(postService.update(principalDetails.getUser(),id,postDTO));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("게시글 수정에 실패되었습니다",e);
        }
    }

    //게시글 삭제
    @ApiOperation(value = "USER : 게시글을 삭제하는 API")
    @DeleteMapping(AUTH + POST + ID)
    public ResponseEntity<?> delete(@AuthenticationPrincipal PrincipalDetails principalDetails,
                                    @ApiParam(value = "게시글의 ID값") @PathVariable Long id) {
        try {
            return ResponseEntity.ok(postService.delete(principalDetails.getUser(),id));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("게시글 삭제에 실패되었습니다",e);
        }
    }





//===============================================================================================
//================================활용 x 차후 Develop때 사용예정 ====================================
//================================================================================================


//    @ApiOperation(value = "ALL : 모든 게시글을 조회하는 API")
//    @GetMapping(POST)
//    public ResponseEntity<?> findAll() {
//        List<PostDTO> postDTOList = postService.findAll();
//        if (postDTOList.size() == 0) {
//            log.error("게시글이 없습니다.");
//            ResponseDTO responseDTO = ResponseDTO.builder().error("게시글이 없습니다.").build();
//            return ResponseEntity.badRequest().body(responseDTO);
//        }
//        return ResponseEntity.ok(postDTOList);
//    }
//
//    지역 + 상세지역으로 filtering된 게시글 조회
//    @ApiOperation(value = "지역 + 상세지역으로 filtering")
//    @GetMapping(AUTH + POST + "/filter/address/detail")
//    public ResponseEntity<?> findByDetailAddressAndAddress(@RequestParam(value = "address") String address,
//                                                           @RequestParam(value = "detailAddress") String detailAddress) {
//        try {
//            return ResponseEntity.ok(postService.findByDetailAddressAndAddress(detailAddress,address));
//        } catch (Exception e) {
//            return ResponseService.makeResponseEntity("게시글이 없습니다.",e);
//        }
//    }
//
//    지역으로 filtering된 게시글 조회
//    @ApiOperation(value = "제목으로 filtering 조회 API")
//    @GetMapping(AUTH + POST + "/filter/title")
//    public ResponseEntity<?> findByTitleLike(@RequestParam(value = "title") String title) {
//        try {
//            return ResponseEntity.ok(postService.findByTitleLike(title));
//        } catch (Exception e) {
//            return ResponseService.makeResponseEntity("게시글이 없습니다.",e);
//        }
//    }
//
//
//    지역으로만 filtering된 게시글 조회
//    @ApiOperation(value = "지역으로만 filtering 조회 API")
//    @GetMapping(AUTH + POST + "/filter/address")
//    public ResponseEntity<?> findByDetailAddressAndAddress(@RequestParam(value = "address") String address) {
//        try {
//            return ResponseEntity.ok(postService.findByAddress(address));
//        } catch (Exception e) {
//            return ResponseService.makeResponseEntity("게시글이 없습니다.",e);
//        }
//    }
}