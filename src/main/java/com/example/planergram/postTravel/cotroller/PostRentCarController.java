package com.example.planergram.postTravel.cotroller;

import com.example.planergram.postTravel.DTO.PostRentCarDTO;
import com.example.planergram.postTravel.service.PostRentCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postrentcar")
public class PostRentCarController {

    @Autowired
    private PostRentCarService postRentCarService;

    @GetMapping("/")
    public String clickStayLike(
            @RequestParam(value="post", defaultValue="0") Long postId,
            @RequestParam(value="rentcar", defaultValue="0") Long rentCarId){
        return postRentCarService.clickRentCarLike(postId,rentCarId);
    }

    @GetMapping("/post/{postId}")
    public List<PostRentCarDTO> postRentCarFindByPost(@PathVariable Long postId){
        return postRentCarService.findByPost(postId);
    }

    @GetMapping("/rentCar/{rentCarId}")
    public List<PostRentCarDTO> postRentCarFindByRentCar(@PathVariable Long rentCarId){
        return postRentCarService.findByRentCar(rentCarId);
    }

    @GetMapping("/{id}")
    public PostRentCarDTO findById(@PathVariable Long id){
        return postRentCarService.findById(id);
    }
}
