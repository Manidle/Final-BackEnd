package com.example.planergram.postTravel.cotroller;

import com.example.planergram.Response.ResponseService;
import com.example.planergram.postTravel.service.PostStayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
@Api(tags = {"게시글에 있는 여행경로(숙소) API 정보를 제공하는 Controller"})
public class PostStayController {

    @Autowired
    private PostStayService postStayService;

    private final String VERSION = "/v1";
    private final String AUTH = "/auth" + VERSION;
    private final String ADMIN_AUTH = "/admin" + AUTH + VERSION;
    private final String POST_CONTENTS = "/post-contents";
    private final String POST_STAY = POST_CONTENTS + "/post-stay";


    @GetMapping(AUTH + POST_STAY + "/click")
    @ApiOperation(value = "USER : 해당 게시글에 숙소를 추가하는 API")
    public ResponseEntity<?> clickPostStay(
            @ApiParam(value = "게시글의 ID값") @RequestParam(value="post", defaultValue="0") Long postId,
            @ApiParam(value = "숙소의 ID값") @RequestParam(value="stay", defaultValue="0") Long stayId){
        try {
            return ResponseEntity.ok(postStayService.clickStayLike(postId, stayId));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("숙소 불러오기를 실패하였습니다.",e);
        }
    }

    @GetMapping(AUTH + "/post/{postId}" + POST_STAY + "/list")
    @ApiOperation(value = "USER : 해당 게시글에 숙소를 조회하는 API")
    public ResponseEntity<?> postStayFindByPost(@ApiParam(value = "게시글의 ID값") @PathVariable Long postId){
        try {
            return ResponseEntity.ok(postStayService.findByPost(postId));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("저장된 렌트카 불러오기를 실패하였습니다.",e);
        }
    }

    @GetMapping(ADMIN_AUTH + POST_STAY + "/list" + "/stay/{stayId}")
    @ApiOperation(value = "ADMIN : 숙소를 게시글에 추가한 경우를 숙소로 조회하는 API")
    public ResponseEntity<?> postStayFindByStay(@ApiParam(value = "숙소의 ID값") @PathVariable Long stayId){
        try {
            return ResponseEntity.ok(postStayService.findByStay(stayId));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("해당 렌트카가 등록된 게시글을 불러오는데 실패하였습니다.",e);
        }
    }

    @GetMapping(ADMIN_AUTH + POST_STAY + "/{id}")
    @ApiOperation(value = "ADMIN : 숙소를 게시글에 추가한 경우를 ID로 조회하는 API")
    public ResponseEntity<?> findById(@ApiParam(value = "포스트 스테이의 ID값") @PathVariable Long id){
        try {
            return ResponseEntity.ok(postStayService.findById(id));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("해당 렌트카가 등록된 게시글을 불러오는데 실패하였습니다.",e);
        }
    }
}