package com.example.planergram.userLike.cotroller;

import com.example.planergram.userLike.DTO.AttractionLikeDTO;
import com.example.planergram.service.AttractionLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attractionlike")
public class AttractionLikeController {
    @Autowired
    private AttractionLikeService attractionLikeService;

    @GetMapping("/")
    public String clickAttractionLike(
            @RequestParam(value="user", defaultValue="0") Long userId,
            @RequestParam(value="attraction", defaultValue ="0") Long attractionId
    ){
        return attractionLikeService.clickAttractionLike(userId, attractionId);
    }

    @GetMapping("/user/{userId}")
    public List<AttractionLikeDTO> attractionLikeFindByUser(@PathVariable Long userId){
        return attractionLikeService.findByUser(userId);
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
