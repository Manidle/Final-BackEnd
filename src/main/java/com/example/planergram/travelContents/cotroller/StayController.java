package com.example.planergram.travelContents.cotroller;

import com.example.planergram.Response.ResponseService;
import com.example.planergram.travelContents.DTO.StayDTO;
import com.example.planergram.travelContents.service.StayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"숙소에 대한 API 정보를 제공하는 Controller"})
@RestController
@RequestMapping("/all")
public class StayController {

    @Autowired
    private StayService stayService;

    @ApiOperation(value = "admin이 숙소정보를 등록하는 API")
    @PostMapping("/admin/auth/v1/register/stay")
    public ResponseEntity<?> signUp(@RequestBody StayDTO stayDTO){
        try {
            return ResponseEntity.ok(stayService.signUp(stayDTO));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("숙소 등록에 실패하였습니다",e);
        }
    }

    @ApiOperation(value = "등록된 숙소정보를 모두 보여주는 API")
    @GetMapping("/auth/v1/list/stay")
    public ResponseEntity<?> findAll(){
        try {
            return ResponseEntity.ok(stayService.findAll());
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("숙소 검색에 실패하였습니다.",e);
        }
    }

    @ApiOperation(value = "등록된 숙소정보를 모두 보여주는 API")
    @GetMapping("/auth/v1/list/stay/1")
    public ResponseEntity<?> findByAddressAndDetailAddress(@RequestParam(value = "address") String address,
                                                           @RequestParam(value = "detailAddress") String detailAddress){
        try {
            return ResponseEntity.ok(stayService.findByAddressAndDetailAddress(address,detailAddress));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("숙소 검색에 실패하였습니다.",e);
        }
    }

    @ApiOperation(value = "등록된 숙소정보를 모두 보여주는 API")
    @GetMapping("/auth/v1/list/stay/2")
    public ResponseEntity<?> findByAddress(@RequestParam(value = "address") String address){
        try {
            return ResponseEntity.ok(stayService.findByAddress(address));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("숙소 검색에 실패하였습니다.",e);
        }
    }

    @ApiOperation(value = "등록된 숙소정보를 모두 보여주는 API")
    @GetMapping("/auth/v1/list/stay/3")
    public ResponseEntity<?> findByNameLike(@RequestParam(value = "name") String name){
        try {
            return ResponseEntity.ok(stayService.findByNameLike(name));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("숙소 검색에 실패하였습니다.",e);
        }
    }

    @ApiOperation(value = "등록된 숙소정보를 모두 보여주는 API")
    @GetMapping("/auth/v1/list/stay/5")
    public ResponseEntity<?> findByNameOrDetailAddressLike(@RequestParam(value = "search") String search){
        try {
            return ResponseEntity.ok(stayService.findByNameOrDetailAddressLike(search));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("숙소 검색에 실패하였습니다.",e);
        }
    }

    @ApiOperation(value = "특정 숙소정보를 보여주는 API")
    @GetMapping("/auth/v1/stay/{id}")
    public ResponseEntity<?> findById(@ApiParam(value = "확인하고싶은 stay의 고유id") @PathVariable Long id){
        try {
            return ResponseEntity.ok(stayService.findById(id));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("숙소 검색에 실패하였습니다.",e);
        }
    }

    @ApiOperation(value = "매니저가 특정 숙소정보를 수정하는 API")
    @PatchMapping("/admin/auth/v1/modify/stay/{id}")
    public ResponseEntity<?> update(@ApiParam(value = "수정하고싶은 stay의 고유id") @PathVariable Long id, @RequestBody StayDTO stayDTO){
        try {
            return ResponseEntity.ok(stayService.update(id,stayDTO));
        } catch (Exception e){
            return ResponseService.makeResponseEntity("숙소 정보수정에 실패했습니다.",e);
        }
    }

    @ApiOperation(value = "매니저가 특정 숙소정보를 삭제하는 API")
    @DeleteMapping("/admin/auth/v1/stay/{id}")
    public ResponseEntity<?> delete(@ApiParam(value = "삭제하고싶은 stay의 고유id") @PathVariable Long id){
        try {
            return ResponseEntity.ok(stayService.delete(id));
        } catch (Exception e){
            return ResponseService.makeResponseEntity("숙소 정보 삭제에 실패했습니다.",e);
        }
    }
}
