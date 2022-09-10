package com.example.planergram.userLike.cotroller;

import com.example.planergram.Response.ResponseService;
import com.example.planergram.userLike.DTO.AttractionLikeDTO;
import com.example.planergram.userLike.service.AttractionLikeService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attractionlike")
public class AttractionLikeController {

    @Autowired
    private AttractionLikeService attractionLikeService;

    @ApiImplicitParams({
                    @ApiImplicitParam(
                            name = "user",value = "user의 아이디",
                            required = true, dataType = "long"
                    ),
                    @ApiImplicitParam(
                            name = "attraction",value = "attraction의 아이디",
                            required = true, dataType = "long"
                    )
    })
    @GetMapping
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

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> attractionLikeFindByUser(@PathVariable Long userId){
        try {
            return ResponseEntity.ok(attractionLikeService.findByUser(userId));
        } catch (Exception e){
            return ResponseService.makeResponseEntity("유저가 좋아요한 관광지 리스트 가져오는 것을 실패했습니다.",e);
        }
    }

    @GetMapping("/attraction/{attractionId}")
    public ResponseEntity<?> attractionLikeFindByAttraction(@PathVariable Long attractionId){
        try {
            return ResponseEntity.ok(attractionLikeService.findByAttraction(attractionId));
        } catch (Exception e){
            return ResponseService.makeResponseEntity("유저가 좋아요한 관광지 리스트 가져오는 것을 실패했습니다.",e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        try {
            return ResponseEntity.ok(attractionLikeService.findById(id));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("관광지 좋아요를 가져오는 것을 실패했습니다.",e);
        }
    }
}
