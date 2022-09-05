package com.example.planergram.userLike.cotroller;

import com.example.planergram.DTO.StayLikeDTO;
import com.example.planergram.service.StayLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StayLikeController {

    @Autowired
    private StayLikeService stayLikeService;

    @GetMapping("/staylike")
    public String clickStayLike(
            @RequestParam(value="user", defaultValue="0") Long userId,
            @RequestParam(value="stay", defaultValue="0") Long stayId){
        return stayLikeService.clickStayLike(userId,stayId);
    }

    @GetMapping("/staylike/user/{userId}")
    public List<StayLikeDTO> StayLikeFindByUser(@PathVariable Long userId){
        return stayLikeService.findByUser(userId);
    }

    @GetMapping("/staylike/stay/{stayId}")
    public List<StayLikeDTO> StayLikeFindByStay(@PathVariable Long stayId){
        return stayLikeService.findByStay(stayId);
    }

    @GetMapping("/staylike/{id}")
    public StayLikeDTO findById(@PathVariable Long id){
        return stayLikeService.findById(id);
    }
}
