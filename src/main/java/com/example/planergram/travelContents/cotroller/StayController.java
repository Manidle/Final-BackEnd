package com.example.planergram.travelContents.cotroller;

import com.example.planergram.Response.ResponseService;
import com.example.planergram.travelContents.DTO.StayDTO;
import com.example.planergram.travelContents.service.StayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stay")
public class StayController {

    @Autowired
    private StayService stayService;

    @PostMapping
    public ResponseEntity<?> signUp(@RequestBody StayDTO stayDTO){
        try {
            return ResponseEntity.ok(stayService.signUp(stayDTO));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("숙소 등록에 실패하였습니다",e);
        }
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        try {
            return ResponseEntity.ok(stayService.findAll());
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("숙소 검색에 실패하였습니다.",e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        try {
            return ResponseEntity.ok(stayService.findById(id));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("숙소 검색에 실패하였습니다.",e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            return ResponseEntity.ok(stayService.delete(id));
        } catch (Exception e){
            return ResponseService.makeResponseEntity("숙소 정보 삭제에 실패했습니다.",e);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody StayDTO stayDTO){
        try {
            return ResponseEntity.ok(stayService.update(id,stayDTO));
        } catch (Exception e){
            return ResponseService.makeResponseEntity("숙소 정보수정에 실패했습니다.",e);
        }
    }
}
