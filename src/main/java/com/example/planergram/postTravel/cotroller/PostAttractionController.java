package com.example.planergram.postTravel.cotroller;

import com.example.planergram.Response.ResponseService;
import com.example.planergram.postTravel.service.PostAttractionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
@Api(tags = {"게시글에 있는 여행경로(관광지) API 정보를 제공하는 Controller"})
public class PostAttractionController {

    @Autowired
    private PostAttractionService postAttractionService;

    private final String VERSION = "/v1";
    private final String AUTH = "/auth" + VERSION;
    private final String ADMIN_AUTH = "/admin" + AUTH;
    private final String POST_CONTENTS = "/post-contents";
    private final String POST_ATTRACTION = POST_CONTENTS + "/post-attraction";

    @GetMapping(AUTH + POST_ATTRACTION)
    @ApiOperation(value = "USER : 해당 게시글에 관광지를 추가하는 API")
    public ResponseEntity<?> clickPostAttraction(
            @ApiParam(value = "게시글의 ID값") @RequestParam(value="post", defaultValue="0") Long postId,
            @ApiParam(value = "숙소의 ID값") @RequestParam(value="stay", defaultValue="0") Long attractionId) {
        try {
            return ResponseEntity.ok(postAttractionService.clickPostAttraction(postId, attractionId));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("관광지 불러오기를 실패했습니다.",e);
        }
    }

    @GetMapping(AUTH + "/post/{postId}" + POST_ATTRACTION)
    @ApiOperation(value = "USER : 해당 게시글에 관광지를 조회하는 API")
    public ResponseEntity<?> postAttractionFindByPost(@ApiParam(value = "게시글의 ID값") @PathVariable Long postId){
        try {
            return ResponseEntity.ok(postAttractionService.findByPost(postId));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("저장된 관광지 불러오기를 실패하였습니다..",e);
        }
    }

    @GetMapping(ADMIN_AUTH + POST_ATTRACTION + "/attraction/{attractionId}")
    @ApiOperation(value = "ADMIN : 관광지를 게시글에 추가한 경우를 관광차로 조회하는 API")
    public ResponseEntity<?> postAttractionFindByAttraction(@ApiParam(value = "관광지의 ID값") @PathVariable Long attractionId){
        try {
            return ResponseEntity.ok(postAttractionService.findByAttraction(attractionId));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("해당 관광지가 등록된 게시글을 불러오는데 실패하였습니다.",e);
        }
    }


    @GetMapping(ADMIN_AUTH + POST_ATTRACTION + "/{id}")
    @ApiOperation(value = "ADMIN : 관광지를 게시글에 추가한 경우를 ID로 조회하는 API")
    public ResponseEntity<?> findById(@ApiParam(value = "포스트 어트랙션의 ID값") @PathVariable Long id){
        try {
            return ResponseEntity.ok(postAttractionService.findById(id));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("저장된 postAttraction을 불러오기 실패하였습니다.",e);
        }
    }
}