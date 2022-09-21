package com.example.planergram.travelContents.cotroller;

import com.example.planergram.Response.ResponseService;
import com.example.planergram.travelContents.DTO.TrainDTO;
import com.example.planergram.travelContents.service.TrainService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"기차에 대한 API 정보를 제공하는 Controller"})
@RestController
@RequestMapping("/api")
public class TrainController {

    @Autowired
    private TrainService trainService;

    @ApiOperation(value = "admin이 기차정보를 등록하는 API")
    @PostMapping("/v1/register/train")
    public ResponseEntity<?> signUp(@RequestBody TrainDTO trainDTO){
        try {
            return ResponseEntity.ok(trainService.signUp(trainDTO));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("관광지 추가가 실패되었습니다.",e);
        }
    }

    @ApiOperation(value = "등록된 기차정보를 모두 보여주는 API")
    @GetMapping("/auth/v1/list/train")
    public ResponseEntity<?> findAll() {
        try {
            return ResponseEntity.ok(trainService.findAll());
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("관광지 리스트를 불러내는데 실패하였습니다.",e);
        }
    }

    // HOT 게시글용 : 모든 기차를 좋아요 순으로 내림차순 정렬하여 상위5개만 출력
    @ApiOperation(value = "HOT 기차용 : 모든기차를 좋아요 순으로 내림차순 정렬조회하는 API")
    @GetMapping("v1/filter/list/train/desc/top")
    public ResponseEntity<?> findTop5ByOrderByLikeCountDesc() {
        try {
            return ResponseEntity.ok(trainService.findTop5ByOrderByLikeCountDesc());
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("Hot한 관광지 리스트를 불러내는데 실패하였습니다.",e);
        }
    }

    @ApiOperation(value = "특정 기차정보를 보여주는 API")
    @GetMapping("/auth/v1/train/{id}")
    public ResponseEntity<?> findById(@ApiParam(value = "확인하고싶은 train의 고유id") @PathVariable Long id){
        try {
            return ResponseEntity.ok(trainService.findById(id));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("관광지 리스트를 불러내는데 실패하였습니다.",e);
        }
    }

    // 출발지 + 도착지로 filtering된 기차정보 조회
    @ApiOperation(value = "출발지 + 도착지로 filtering")
    @GetMapping("/auth/v1/filter/list/train/dep/arr")
    public ResponseEntity<?> findByStartPointAndEndPoint(@RequestParam(value = "startPoint") String startPoint,
                                                         @RequestParam(value = "endPoint") String endPoint) {
        try {
            return ResponseEntity.ok(trainService.findByStartPointAndEndPoint(startPoint,endPoint));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("게시글이 없습니다.",e);
        }
    }

    @ApiOperation(value = "매니저가 특정 기차정보를 수정하는 API")
    @PatchMapping("/admin/auth/v1/modify/train/{id}")
    public TrainDTO update(@ApiParam(value = "수정하고싶은 train의 고유id") @PathVariable Long id, @RequestBody TrainDTO trainDTO){
        return trainService.update(id,trainDTO);
    }

    @ApiOperation(value = "매니저가 특정 기차정보를 삭제하는 API")
    @DeleteMapping("/admin/auth/v1/{id}")
    public ResponseEntity<?> delete(@ApiParam(value = "삭제하고싶은 train의 고유id") @PathVariable Long id){
        try {
            return ResponseEntity.ok(trainService.delete(id));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("관광지를 삭제하는데 실패하였습니다.",e);
        }
    }
}
