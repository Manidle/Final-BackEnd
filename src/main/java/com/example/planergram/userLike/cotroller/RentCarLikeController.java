package com.example.planergram.userLike.cotroller;


import com.example.planergram.Response.ResponseService;
import com.example.planergram.userLike.service.RentCarLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class RentCarLikeController {

    @Autowired
    private RentCarLikeService rentCarLikeService;

    @GetMapping("/v1/like/lick/rentcar")
    public ResponseEntity<?> clickRentCarLike(
            @RequestParam(value="user", defaultValue="0") Long userId,
            @RequestParam(value="rentcar", defaultValue="0") Long rentCarId){
        try {
            return ResponseEntity.ok(rentCarLikeService.clickRentCarLike(userId,rentCarId));
        } catch (Exception e){
            return ResponseService.makeResponseEntity("랜트카 좋아요 클릭을 실패했습니다.",e);
        }
    }

    @GetMapping("/v1/currentuser/like/rentcar/{userId}")
    public ResponseEntity<?> RentCarLikeFindByUser(@PathVariable Long userId){
        try {
            return ResponseEntity.ok(rentCarLikeService.findByUser(userId));
        } catch (Exception e){
            return ResponseService.makeResponseEntity("유저가 좋아요한 랜트카 리스트 가져오는 것을 실패했습니다.",e);
        }
    }

    @GetMapping("/v1/like/rentcar/{rentcarId}")
    public ResponseEntity<?> RentCarLikeFindByStay(@PathVariable Long rentcarId){
        try {
            return ResponseEntity.ok(rentCarLikeService.findByRentCar(rentcarId));
        } catch (Exception e){
            return ResponseService.makeResponseEntity("해당렌트카의 좋아요 추출을 실패했습니다.",e);
        }
    }

    @GetMapping("/v1/like/rentcar/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        try {
            return ResponseEntity.ok(rentCarLikeService.findById(id));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("좋아요를 가져오는 것을 실패했습니다.",e);
        }
    }
}