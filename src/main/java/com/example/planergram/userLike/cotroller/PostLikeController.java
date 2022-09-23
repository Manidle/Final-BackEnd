package com.example.planergram.userLike.cotroller;

import com.example.planergram.Response.ResponseService;
import com.example.planergram.userLike.service.PostLikeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"게시글 좋아요에 대한 API 정보를 제공하는 Controller"})
@RestController
@RequestMapping("/api/auth")
@Slf4j
public class PostLikeController {

    @Autowired
    private PostLikeService postLikeService;

    @ApiOperation(value = "특정유저가 특정게시글을 좋아요 클릭하는 API")
    @GetMapping("/v1/like/click/post")
    public ResponseEntity<?> clickPostLike(@RequestParam(value = "user", defaultValue = "0") Long userId,
                                           @RequestParam(value = "post", defaultValue = "0") Long postId) {
        try {
            log.info("postLike Click 발생 : userId : {}     postId : {}",userId,postId);
            return ResponseEntity.ok(postLikeService.clickPostLike(userId, postId));
        } catch (Exception e){
            return ResponseService.makeResponseEntity("게시글 좋아요 클릭을 실패했습니다.",e);
        }

    }

    @ApiOperation(value = "특정유저가 좋아요 누른 게시글을 모두 보여주는 API")
    @GetMapping("/v1/list/currentuser/like/post/{userId}")
    public ResponseEntity<?> postLikeFindByUser(@ApiParam(value = "확인하고싶은 user의 고유id") @PathVariable Long userId){
        try {
            return ResponseEntity.ok(postLikeService.findByUser(userId));
        } catch (Exception e){
            return ResponseService.makeResponseEntity("유저가 좋아요한 게시글 리스트 가져오는 것을 실패했습니다.",e);
        }
    }

    @ApiOperation(value = "특정관광지의 게시글을 모두 보여주는 API")
    @GetMapping("/v1/list/like/post/{postId}")
    public ResponseEntity<?> postLikeFindByPost(@ApiParam(value = "확인하고싶은 post 고유id") @PathVariable Long postId){
        try {
            return ResponseEntity.ok(postLikeService.findByPost(postId));
        } catch (Exception e){
            return ResponseService.makeResponseEntity("해당게시글의 좋아요 추출을 실패했습니다.",e);
        }
    }

    @ApiOperation(value = "게시글&좋아요 1:1 형태로 모두 보여주는 API")
    @GetMapping("/v1/like/post/{id}")
    public ResponseEntity<?> findById(@ApiParam(value = "확인하고싶은 postLike의 고유id") @PathVariable Long id){
        try {
            return ResponseEntity.ok(postLikeService.findById(id));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("좋아요를 가져오는 것을 실패했습니다.",e);
        }
    }
}