package com.example.planergram.travelContents.cotroller;

import com.example.planergram.Response.ResponseService;
import com.example.planergram.travelContents.DTO.AttractionDTO;
import com.example.planergram.travelContents.service.AttractionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"관광지에 대한 API 정보를 제공하는 Controller"})
@RequestMapping("/api")
@RestController
public class AttractionController {

    @Autowired
    private AttractionService attractionService;

    @ApiOperation(value = "admin이 관광지정보를 등록하는 API")
    @PostMapping("/admin/auth/v1/register/attraction")
    public ResponseEntity<?> signUp(@RequestBody AttractionDTO attractionDTO){
        try {
            return ResponseEntity.ok(attractionService.signUp(attractionDTO));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("관광지 추가가 실패되었습니다.",e);
        }
    }

    @ApiOperation(value = "등록된 관광지정보를 모두 보여주는 API")
    @GetMapping("/auth/v1/list/attraction")
    public ResponseEntity<?> findAll(){
        try {
            return ResponseEntity.ok(attractionService.findAll());
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("관광지 리스트를 불러내는데 실패하였습니다.",e);
        }
    }

    // HOT 관광지용 : 모든 관광지를 좋아요 순으로 내림차순 정렬하여 상위5개만 출력
    @ApiOperation(value = "모든 관광지를 좋아요 순으로 내림차순 정렬하여 상위5개만 보여주는 API")
    @GetMapping("v1/filter/list/attraction/desc/top")
    public ResponseEntity<?> findAllByOrderByLikeCountDesc(){
        try {
            return ResponseEntity.ok(attractionService.findTop5ByOrderByLikeCountDesc());
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("HOT 관광지 리스트를 불러내는데 실패하였습니다.",e);
        }
    }

    // 지역 + 상세지역으로 filtering된 관광지 조회
    @ApiOperation(value = "지역 + 상세지역으로 filtering")
    @GetMapping("/auth/v1/list/filter/attraction/address/detail")
    public ResponseEntity<?> findByAddressAndDetailAddress(@RequestParam(value = "address") String address,
                                                           @RequestParam(value = "detailAddress") String detailAddress){
        try {
            return ResponseEntity.ok(attractionService.findByAddressAndDetailAddress(address,detailAddress));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("관광지 리스트를 불러내는데 실패하였습니다.",e);
        }
    }

    //지역으로만 filtering된 관광지 조회
    @ApiOperation(value = "지역으로만 filtering 조회 API")
    @GetMapping("/auth/v1/list/filter/attraction/address")
    public ResponseEntity<?> findByAddress(@RequestParam(value = "address") String address){
        try {
            return ResponseEntity.ok(attractionService.findByAddress(address));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("관광지 리스트를 불러내는데 실패하였습니다.",e);
        }
    }

    //관광지 이름으로 filtering된 게시글 조회
    @ApiOperation(value = "관광지 이름으로 filtering 조회 API")
    @GetMapping("/auth/v1/list/filter/attraction/name")
    public ResponseEntity<?> findByNameLike(@RequestParam(value = "name") String name){
        try {
            return ResponseEntity.ok(attractionService.findByNameLike(name));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("관광지 리스트를 불러내는데 실패하였습니다.",e);
        }
    }
    //관광지 이름,지역,상세지역 중 Like filtering된 게시글 조회
    @ApiOperation(value = "검색필터 관광지정보를 모두 보여주는 API")
    @GetMapping("/filter/attraction/search")
    public ResponseEntity<?> findByNameOrDetailAddressLike(@RequestParam("search") String search){
        try {
            return ResponseEntity.ok(attractionService.findByNameOrDetailAddressLike(search));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("관광지 리스트를 불러내는데 실패하였습니다.",e);
        }
    }

    @ApiOperation(value = "특정 관광지정보를 보여주는 API")
    @GetMapping("/auth/v1/attraction/{id}")
    public ResponseEntity<?> findById(@ApiParam(value = "확인하고싶은 attraction의 고유id") @PathVariable Long id){
        try {
            return ResponseEntity.ok(attractionService.findById(id));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("관광지를 불러내는데 실패하였습니다.",e);
        }
    }

    @ApiOperation(value = "매니저가 특정 관광지정보를 수정하는 API")
    @PatchMapping("/admin/auth/v1/modify/attraction/{id}")
    public ResponseEntity<?> update(@ApiParam(value = "수정하고싶은 attraction의 고유id") @PathVariable Long id, @RequestBody AttractionDTO attractionDTO){
        try {
            return ResponseEntity.ok(attractionService.update(id,attractionDTO));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("관광지 수정에 실패하였습니다.",e);
        }
    }

    @ApiOperation(value = "매니저가 특정 관광지정보를 삭제하는 API")
    @DeleteMapping("/admin/auth/v1/attraction/{id}")
    public ResponseEntity<?> delete(@ApiParam(value = "삭제하고싶은 attraction의 고유id") @PathVariable Long id){
        try {
            return ResponseEntity.ok(attractionService.delete(id));
        } catch (Exception e){
            return ResponseService.makeResponseEntity("관광지 정보 삭제에 실패했습니다.",e);
        }
    }
}
