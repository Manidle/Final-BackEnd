package com.example.planergram.userLike.cotroller;

import com.example.planergram.Response.ResponseService;
import com.example.planergram.userLike.service.AttractionLikeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"관광지 좋아요에 대한 API 정보를 제공하는 Controller"})
@RestController
@RequestMapping("/api/auth")
public class AttractionLikeController {

    @Autowired
    private AttractionLikeService attractionLikeService;

    @ApiOperation(value = "특정유저가 특정관광지를 좋아요 클릭하는 API")
    @GetMapping("/v1/like/click/attraction")
    public ResponseEntity<?> clickAttractionLike(
            @RequestParam(value="user", defaultValue="0") Long userId,
            @RequestParam(value="attraction", defaultValue ="0") Long attractionId
    ){
        try {
            return ResponseEntity.ok(attractionLikeService.clickAttractionLike(userId, attractionId));
        } catch (Exception e){
            return ResponseService.makeResponseEntity("관광지 좋아요 클릭을 실패했습니다.",e);
        }
    }

    @ApiOperation(value = "특정유저가 좋아요 누른 관광지를 모두 보여주는 API")
    @GetMapping("/v1/getlist/currentuser/like/attraction/{userId}")
    public ResponseEntity<?> attractionLikeFindByUser(@ApiParam(value = "확인하고싶은 user의 고유id") @PathVariable Long userId){
        try {
            return ResponseEntity.ok(attractionLikeService.findByUser(userId));
        } catch (Exception e){
            return ResponseService.makeResponseEntity("유저가 좋아요한 관광지 리스트 가져오는 것을 실패했습니다.",e);
        }
    }

    @ApiOperation(value = "특정관광지의 좋아요를 모두 보여주는 API")
    @GetMapping("/v1/getlist/like/attraction/{attractionId}")
    public ResponseEntity<?> attractionLikeFindByAttraction(@ApiParam(value = "확인하고싶은 attractionLike의 고유id") @PathVariable Long attractionId){
        try {
            return ResponseEntity.ok(attractionLikeService.findByAttraction(attractionId));
        } catch (Exception e){
            return ResponseService.makeResponseEntity("해당관광지의 좋아요 추출을 실패했습니다.",e);
        }
    }

    @ApiOperation(value = "관광지&좋아요를 1:1 형태로 모두 보여주는 API")
    @GetMapping("/v1/like/getattraction/{id}")
    public ResponseEntity<?> findById(@ApiParam(value = "확인하고싶은 attractionLike의 고유id") @PathVariable Long id){
        try {
            return ResponseEntity.ok(attractionLikeService.findById(id));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("좋아요를 가져오는 것을 실패했습니다.",e);
        }
    }
}
