package com.example.planergram.travelContents.cotroller;

import com.example.planergram.Response.ResponseService;
import com.example.planergram.travelContents.DTO.AttractionDTO;
import com.example.planergram.travelContents.service.AttractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/attraction")
@RestController
public class AttractionController {

    @Autowired
    private AttractionService attractionService;

    @PostMapping
    public ResponseEntity<?> signUp(@RequestBody AttractionDTO attractionDTO){
        try {
            return ResponseEntity.ok(attractionService.signUp(attractionDTO));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("관광지 추가가 실패되었습니다.",e);
        }
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        try {
            return ResponseEntity.ok(attractionService.findAll());
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("관광지 리스트를 불러내는데 실패하였습니다.",e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        try {
            return ResponseEntity.ok(attractionService.findById(id));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("관광지를 불러내는데 실패하였습니다.",e);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody AttractionDTO attractionDTO){
        try {
            return ResponseEntity.ok(attractionService.update(id,attractionDTO));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("관광지 수정에 실패하였습니다.",e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            return ResponseEntity.ok(attractionService.delete(id));
        } catch (Exception e){
            return ResponseService.makeResponseEntity("관광지 정보 삭제에 실패했습니다.",e);
        }
    }
}
