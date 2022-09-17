package com.example.planergram.postTravel.cotroller;

import com.example.planergram.Response.ResponseService;
import com.example.planergram.postTravel.service.PostTrainService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
@Api(tags = {"게시글에 있는 여행경로(기차) API 정보를 제공하는 Controller"})
public class PostTrainController {

    @Autowired
    private PostTrainService postTrainService;

    private final String VERSION = "/v1";
    private final String AUTH = "/auth" + VERSION;
    private final String ADMIN_AUTH = "/admin" + AUTH;
    private final String POST_CONTENTS = "/post-contents";
    private final String POST_TRAIN = POST_CONTENTS + "/post-train";


    @GetMapping(AUTH + POST_TRAIN)
    @ApiOperation(value = "USER : 해당 게시글에 기차를 추가하는 API")
    public ResponseEntity<?> clickTrainLike(
            @ApiParam(value = "게시글의 ID값") @RequestParam(value="post", defaultValue="0") Long postId,
            @ApiParam(value = "기차의 ID값") @RequestParam(value="train", defaultValue="0") Long trainId){
        try {
            return ResponseEntity.ok(postTrainService.clickTrainLike(postId,trainId ));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("저장된 postRentCar 불러오기 실패하였습니다.",e);
        }
    }

    @GetMapping(AUTH + "/post/{postId}" + POST_TRAIN)
    @ApiOperation(value = "USER : 해당 게시글에 기차를 조회하는 API")
    public ResponseEntity<?> postTrainFindByPost(@ApiParam(value = "게시글의 ID값") @PathVariable Long postId){
        try {
            return ResponseEntity.ok(postTrainService.findByPost(postId));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("저장된 렌트카 불러오기를 실패하였습니다.",e);
        }
    }

    @GetMapping(ADMIN_AUTH + POST_TRAIN + "/train/{trainId}")
    @ApiOperation(value = "ADMIN : 기차를 게시글에 추가한 경우를 기차로 조회하는 API")
    public ResponseEntity<?> postTrainFindByTrain(@ApiParam(value = "기차의 ID값") @PathVariable Long trainId){
        try {
            return ResponseEntity.ok(postTrainService.findByTrain(trainId));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("해당 렌트카가 등록된 게시글을 불러오는데 실패하였습니다.",e);
        }
    }

    @GetMapping(ADMIN_AUTH + POST_TRAIN + "/{id}")
    @ApiOperation(value = "ADMIN : 기차를 게시글에 추가한 경우를 ID로 조회하는 API")
    public ResponseEntity<?> findById(@ApiParam(value = "포스트 트레인의 ID값") @PathVariable Long id){
        try {
            return ResponseEntity.ok(postTrainService.findById(id));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("저장된 postRentCar 불러오기 실패하였습니다.",e);
        }
    }
}
