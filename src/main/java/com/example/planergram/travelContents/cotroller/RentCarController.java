package com.example.planergram.travelContents.cotroller;

import com.example.planergram.Response.ResponseService;
import com.example.planergram.travelContents.DTO.RentCarDTO;
import com.example.planergram.travelContents.service.RentCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rentcar")
public class RentCarController {

    @Autowired
    private RentCarService rentCarService;

    @PostMapping
    public ResponseEntity<?> signUp(@RequestBody RentCarDTO rentCarDTO){
        try {
            return ResponseEntity.ok(rentCarService.signUp(rentCarDTO));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("렌트카 등록에 실패하였습니다.",e);
        }
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        try {
            return ResponseEntity.ok(rentCarService.findAll());
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("렌트카 정보를 부르는데 실패하였습니다.",e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        try {
            return ResponseEntity.ok(rentCarService.findById(id));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("렌트카 정보를 부르는데 실패하였습니다.",e);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody RentCarDTO rentCarDTO){
        try {
            return ResponseEntity.ok(rentCarService.update(id,rentCarDTO));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("렌트카 정보를 수정하는데 실패하였습니다.",e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            return ResponseEntity.ok(rentCarService.delete(id));
        } catch (Exception e){
            return ResponseService.makeResponseEntity("렌트카 정보를 삭제하는데 실패하였습니다.",e);
        }
    }
}