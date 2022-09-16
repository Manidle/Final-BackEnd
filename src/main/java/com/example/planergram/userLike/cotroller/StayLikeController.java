package com.example.planergram.userLike.cotroller;

import com.example.planergram.Response.ResponseService;
import com.example.planergram.userLike.service.StayLikeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"숙소 좋아요에 대한 API 정보를 제공하는 Controller"})
@RestController
@RequestMapping("/api/auth")
public class StayLikeController {

    @Autowired
    private StayLikeService stayLikeService;

    @ApiOperation(value = "특정유저가 특정숙소를 좋아요 클릭하는 API")
    @GetMapping("/v1/like/click/stay")
    public ResponseEntity<?> clickStayLike(
            @RequestParam(value="user", defaultValue="0") Long userId,
            @RequestParam(value="stay", defaultValue="0") Long stayId){
        try {
            return ResponseEntity.ok(stayLikeService.clickStayLike(userId,stayId));
        } catch (Exception e){
            return ResponseService.makeResponseEntity("숙소 좋아요 클릭을 실패했습니다.",e);
        }
    }

    @ApiOperation(value = "특정유저가 좋아요 누른 숙소를 모두 보여주는 API")
    @GetMapping("/v1/getlist/currentuser/like/stay/{userId}")
    public ResponseEntity<?> StayLikeFindByUser(@ApiParam(value = "확인하고싶은 user의 고유id") @PathVariable Long userId){
        try {
            return ResponseEntity.ok(stayLikeService.findByUser(userId));
        } catch (Exception e){
            return ResponseService.makeResponseEntity("유저가 좋아요한 숙소 리스트 가져오는 것을 실패했습니다.",e);
        }
    }

    @ApiOperation(value = "특정숙소의 좋아요를 모두 보여주는 API")
    @GetMapping("/v1/getlist/like/stay/{stayId}")
    public ResponseEntity<?> StayLikeFindByStay(@ApiParam(value = "확인하고싶은 stay의 고유id") @PathVariable Long stayId){
        try {
            return ResponseEntity.ok(stayLikeService.findByStay(stayId));
        } catch (Exception e){
            return ResponseService.makeResponseEntity("유저가 좋아요한 숙소 리스트 가져오는 것을 실패했습니다.",e);
        }
    }

    @ApiOperation(value = "숙소&좋아요를 1:1 형태로 모두 보여주는 API")
    @GetMapping("/v1/like/getstay/{id}")
    public ResponseEntity<?> findById(@ApiParam(value = "확인하고싶은 stayLike의 고유id") @PathVariable Long id){
        try {
            return ResponseEntity.ok(stayLikeService.findById(id));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("숙소 좋아요를 가져오는 것을 실패했습니다.",e);
        }
    }
}
