package com.example.planergram.userLike.cotroller;

import com.example.planergram.Response.ResponseService;
import com.example.planergram.userLike.DTO.AttractionLikeDTO;
import com.example.planergram.userLike.service.AttractionLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attractionlike")
public class AttractionLikeController {
    @Autowired
    private AttractionLikeService attractionLikeService;

    @GetMapping("/")
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

    @GetMapping("/user/{attractionId}")
    public List<AttractionLikeDTO> attractionLikeFindByAttraction(@PathVariable Long attractionId){
        return attractionLikeService.findByAttraction(attractionId);
    }

    @GetMapping("/{id}")
    public AttractionLikeDTO findById(@PathVariable Long id){
        return attractionLikeService.findById(id);
    }
}
