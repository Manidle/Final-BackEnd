package com.example.planergram.postTravel.cotroller;

import com.example.planergram.Response.ResponseService;
import com.example.planergram.postTravel.DTO.PostTrainDTO;
import com.example.planergram.postTravel.service.PostTrainService;
import com.example.planergram.travelContents.model.Platform;
import com.example.planergram.travelContents.repository.PlatformRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
@Api(tags = {"게시글에 있는 여행경로(기차) API 정보를 제공하는 Controller"})
public class PostTrainController {

    @Autowired
    private PostTrainService postTrainService;

    @Autowired
    private PlatformRepository platformRepository;

    private final String VERSION = "/v1";
    private final String AUTH = "/auth" + VERSION;
    private final String ADMIN_AUTH = "/admin" + AUTH;
    private final String POST_CONTENTS = "/post-contents";
    private final String POST_TRAIN = POST_CONTENTS + "/post-train";


    @PostMapping("/auth/v1/postcontents/posttrain/click/{postId}")
    @ApiOperation(value = "USER : 해당 게시글에 기차를 추가하는 API")
    public ResponseEntity<?> clickTrainLike(@ApiParam(value = "게시글의 ID값") @PathVariable Long postId, @RequestBody PostTrainDTO postTrainDTO) {


        postTrainDTO.setDepplaceNodeName(postTrainDTO.getDepplacename());
        postTrainDTO.setArrplaceNodeName(postTrainDTO.getArrplacename());

        Platform startPoint = platformRepository.findByNodeName(postTrainDTO.getDepplacename());
        String encStartPoint = startPoint.getNodeId();
        postTrainDTO.setDepplacename(encStartPoint);

        Platform endPoint = platformRepository.findByNodeName(postTrainDTO.getArrplacename());
        String encEndPoint = endPoint.getNodeId();
        postTrainDTO.setArrplacename(encEndPoint);



        try {
            return ResponseEntity.ok(postTrainService.clickTrainLike(postId, postTrainDTO));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("저장된 postRentCar 불러오기 실패하였습니다.", e);
        }
    }

    @GetMapping("/auth/v1/post/{postId}/post-contents/post-train/list")
    @ApiOperation(value = "USER : 해당 게시글에 기차를 조회하는 API")
    public ResponseEntity<?> postTrainFindByPost(@ApiParam(value = "게시글의 ID값") @PathVariable Long postId) {
        try {
            return ResponseEntity.ok(postTrainService.findByPost(postId));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("지정된 렌트카 불러오기를 실패하였습니다.", e);
        }
    }

    @GetMapping(ADMIN_AUTH + POST_TRAIN + "/{id}")
    @ApiOperation(value = "ADMIN : 기차를 게시글에 추가한 경우를 ID로 조회하는 API")
    public ResponseEntity<?> findById(@ApiParam(value = "포스트 트레인의 ID값") @PathVariable Long id) {
        try {
            return ResponseEntity.ok(postTrainService.findById(id));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("저장된 postRentCar 불러오기 실패하였습니다.", e);
        }
    }
}
