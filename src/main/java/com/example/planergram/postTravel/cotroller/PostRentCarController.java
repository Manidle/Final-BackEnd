package com.example.planergram.postTravel.cotroller;

import com.example.planergram.Response.ResponseService;
import com.example.planergram.postTravel.service.PostRentCarService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
@Slf4j
@Api(tags = {"게시글에 있는 여행경로(랜트카) API 정보를 제공하는 Controller"})
public class PostRentCarController {

    @Autowired
    private PostRentCarService postRentCarService;

    private final String VERSION = "/v1";
    private final String AUTH = "/auth" + VERSION;
    private final String ADMIN_AUTH = "/admin" + AUTH;
    private final String POST_CONTENTS = "/post-contents";
    private final String POST_RENT_CAR = POST_CONTENTS + "/post-rent-car";


    @GetMapping(AUTH + POST_RENT_CAR + "/click")
    @ApiOperation(value = "USER : 해당 게시글에 랜트카를 추가하는 API")
    public ResponseEntity<?> clickPostRentCar(
            @ApiParam(value = "게시글의 ID값") @RequestParam(value="post", defaultValue="0") Long postId,
            @ApiParam(value = "랜트카의 ID값") @RequestParam(value="rentcar", defaultValue="0") Long rentCarId
            ){
        log.info("click Post RentCar");
        try {

            return ResponseEntity.ok(postRentCarService.clickRentCarLike(postId,rentCarId));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("렌트카 불러오기를 실패하였습니다.",e);
        }
    }

    @GetMapping(AUTH + "/post/{postId}" + POST_RENT_CAR + "/list")
    @ApiOperation(value = "USER : 해당 게시글에 랜트카를 조회하는 API")
    public ResponseEntity<?> postRentCarFindByPost(@ApiParam(value = "게시글의 ID값") @PathVariable Long postId){
        try {
            return ResponseEntity.ok(postRentCarService.findByPost(postId));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("저장된 렌트카 불러오기를 실패하였습니다.",e);
        }
    }

    @GetMapping(ADMIN_AUTH + POST_RENT_CAR + "/list" + "/rent-car/{rentCarId}")
    @ApiOperation(value = "ADMIN : 랜트카를 게시글에 추가한 경우를 랜트카로 조회하는 API")
    public ResponseEntity<?> postRentCarFindByRentCar(@ApiParam(value = "랜트카의 ID값") @PathVariable Long rentCarId){
        try {
            return ResponseEntity.ok(postRentCarService.findByRentCar(rentCarId));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("해당 렌트카가 등록된 게시글을 불러오는데 실패하였습니다.",e);
        }
    }

    @GetMapping(ADMIN_AUTH + POST_RENT_CAR + "/{id}")
    @ApiOperation(value = "ADMIN : 랜트카를 게시글에 추가한 경우를 ID로 조회하는 API")
    public ResponseEntity<?> findById(@ApiParam(value = "포스트 랜트카의 ID값") @PathVariable Long id){
        try {
            return ResponseEntity.ok(postRentCarService.findById(id));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("저장된 postRentCar 불러오기 실패하였습니다.",e);
        }
    }
}