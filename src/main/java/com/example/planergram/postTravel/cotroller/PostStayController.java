package com.example.planergram.postTravel.cotroller;

import com.example.planergram.postTravel.DTO.PostStayDTO;
import com.example.planergram.service.PostStayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/poststay")
public class PostStayController {

    @Autowired
    private PostStayService postStayService;

    @GetMapping("/")
    public String clickStayLike(
            @RequestParam(value="post", defaultValue="0") Long postId,
            @RequestParam(value="stay", defaultValue="0") Long stayId){
        return postStayService.clickStayLike(postId,stayId);
    }

    @GetMapping("/post/{postId}")
    public List<PostStayDTO> postStayFindByPost(@PathVariable Long postId){
        return postStayService.findByPost(postId);
    }

    @GetMapping("/stay/{stayId}")
    public List<PostStayDTO> postStayFindByStay(@PathVariable Long stayId){
        return postStayService.findByStay(stayId);
    }

    @GetMapping("/{id}")
    public PostStayDTO findById(@PathVariable Long id){
        return postStayService.findById(id);
    }
}
