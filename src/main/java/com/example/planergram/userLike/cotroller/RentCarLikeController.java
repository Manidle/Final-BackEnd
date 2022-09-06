package com.example.planergram.userLike.cotroller;


import com.example.planergram.Response.ResponseService;
import com.example.planergram.userLike.DTO.RentCarLikeDTO;
import com.example.planergram.userLike.service.RentCarLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rentcarlike")
public class RentCarLikeController {

    @Autowired
    private RentCarLikeService rentCarLikeService;

    @GetMapping
    public ResponseEntity<?> clickRentCarLike(
            @RequestParam(value="user", defaultValue="0") Long userId,
            @RequestParam(value="rentCar", defaultValue="0") Long rentCarId){
        try {
            return ResponseEntity.ok(rentCarLikeService.clickRentCarLike(userId,rentCarId));
        } catch (Exception e){
            return ResponseService.makeResponseEntity("랜트카 좋아요 클릭을 실패했습니다.",e);
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> RentCarLikeFindByUser(@PathVariable Long userId){
        try {
            return ResponseEntity.ok(rentCarLikeService.findByUser(userId));
        } catch (Exception e){
            return ResponseService.makeResponseEntity("유저가 좋아요한 랜트카 리스트 가져오는 것을 실패했습니다.",e);
        }
    }

    @GetMapping("/rentcar/{rentcarId}")
    public List<RentCarLikeDTO> RentCarLikeFindByStay(@PathVariable Long rentcarId){
        return rentCarLikeService.findByRentCar(rentcarId);
    }

    @GetMapping("/{id}")
    public RentCarLikeDTO findById(@PathVariable Long id){
        return rentCarLikeService.findById(id);
    }
}
