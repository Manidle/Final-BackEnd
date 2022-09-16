package com.example.planergram.userLike.cotroller;

import com.example.planergram.Response.ResponseService;
import com.example.planergram.userLike.service.StayLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class StayLikeController {

    @Autowired
    private StayLikeService stayLikeService;

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

    @GetMapping("/v1/currentuser/like/stay/{userId}")
    public ResponseEntity<?> StayLikeFindByUser(@PathVariable Long userId){
        try {
            return ResponseEntity.ok(stayLikeService.findByUser(userId));
        } catch (Exception e){
            return ResponseService.makeResponseEntity("유저가 좋아요한 숙소 리스트 가져오는 것을 실패했습니다.",e);
        }
    }

    @GetMapping("/v1/like/stay/{stayId}")
    public ResponseEntity<?> StayLikeFindByStay(@PathVariable Long stayId){
        try {
            return ResponseEntity.ok(stayLikeService.findByStay(stayId));
        } catch (Exception e){
            return ResponseService.makeResponseEntity("유저가 좋아요한 숙소 리스트 가져오는 것을 실패했습니다.",e);
        }
    }

    @GetMapping("/v1/like/stay/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        try {
            return ResponseEntity.ok(stayLikeService.findById(id));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("숙소 좋아요를 가져오는 것을 실패했습니다.",e);
        }
    }
}
