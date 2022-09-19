package com.example.planergram.travelContents.cotroller;

import com.example.planergram.Response.ResponseService;
import com.example.planergram.travelContents.DTO.RentCarDTO;
import com.example.planergram.travelContents.service.RentCarService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"렌트카에 대한 API 정보를 제공하는 Controller"})
@RestController
@RequestMapping("/all")
public class RentCarController {

    @Autowired
    private RentCarService rentCarService;

    @ApiOperation(value = "admin이 렌트카정보를 등록하는 API")
    @PostMapping("/admin/auth/v1/register/rentcar")
    public ResponseEntity<?> signUp(@RequestBody RentCarDTO rentCarDTO){
        try {
            return ResponseEntity.ok(rentCarService.signUp(rentCarDTO));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("렌트카 등록에 실패하였습니다.",e);
        }
    }

    @ApiOperation(value = "등록된 렌트카정보를 모두 보여주는 API")
    @GetMapping("/auth/v1/list/rentcar")
    public ResponseEntity<?> findAll(){
        try {
            return ResponseEntity.ok(rentCarService.findAll());
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("렌트카 정보를 부르는데 실패하였습니다.",e);
        }
    }

    @ApiOperation(value = "지역 + 상세지역으로 filtering 조회 API")
    @GetMapping("/filter/rentcar/detail")
    public ResponseEntity<?> findByDetailAddressAndAddress(@RequestParam(value = "address") String address,
                                                           @RequestParam(value = "detailAddress") String detailAddress){
        try {
            return ResponseEntity.ok(rentCarService.findByAddressAndDetailAddress(address,detailAddress));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("렌트카 정보를 부르는데 실패하였습니다.",e);
        }
    }

    @ApiOperation(value = "지역으로 filtering 조회 API")
    @GetMapping("/filter/rentcar")
    public ResponseEntity<?> findByAddress(@RequestParam(value = "address") String address){
        try {
            return ResponseEntity.ok(rentCarService.findByAddress(address));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("렌트카 정보를 부르는데 실패하였습니다.",e);
        }
    }

    @ApiOperation(value = "렌트카 이름으로 filtering 조회 API")
    @GetMapping("/filter/carname")
    public ResponseEntity<?> findByCarNameLike(@RequestParam(value = "carname") String carName){
        try {
            return ResponseEntity.ok(rentCarService.findByCarNameLike(carName));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("렌트카 정보를 부르는데 실패하였습니다.",e);
        }
    }

    @ApiOperation(value = "특정 렌트카정보를 보여주는 API")
    @GetMapping("/auth/v1/rentcar/{id}")
    public ResponseEntity<?> findById(@ApiParam(value = "확인하고싶은 rentcar의 고유id") @PathVariable Long id){
        try {
            return ResponseEntity.ok(rentCarService.findById(id));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("렌트카 정보를 부르는데 실패하였습니다.",e);
        }
    }

    @ApiOperation(value = "매니저가 특정 렌트카정보를 수정하는 API")
    @PatchMapping("/admin/auth/v1/modify/rentcar/{id}")
    public ResponseEntity<?> update(@ApiParam(value = "수정하고싶은 rentcar의 고유id") @PathVariable Long id, @RequestBody RentCarDTO rentCarDTO){
        try {
            return ResponseEntity.ok(rentCarService.update(id,rentCarDTO));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("렌트카 정보를 수정하는데 실패하였습니다.",e);
        }
    }

    @ApiOperation(value = "매니저가 특정 렌트카정보를 삭제하는 API")
    @DeleteMapping("/admin/auth/v1/rentcar/{id}")
    public ResponseEntity<?> delete(@ApiParam(value = "삭제하고싶은 rentcar의 고유id") @PathVariable Long id){
        try {
            return ResponseEntity.ok(rentCarService.delete(id));
        } catch (Exception e){
            return ResponseService.makeResponseEntity("렌트카 정보를 삭제하는데 실패하였습니다.",e);
        }
    }
}