package com.example.planergram.travelContents.cotroller;

import com.example.planergram.Response.ResponseService;
import com.example.planergram.travelContents.DTO.TrainDTO;
import com.example.planergram.travelContents.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/train")
public class TrainController {

    @Autowired
    private TrainService trainService;

    @PostMapping
    public ResponseEntity<?> signUp(@RequestBody TrainDTO trainDTO){
        try {
            return ResponseEntity.ok(trainService.signUp(trainDTO));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("관광지 추가가 실패되었습니다.",e);
        }
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        try {
            return ResponseEntity.ok(trainService.findAll());
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("관광지 리스트를 불러내는데 실패하였습니다.",e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        try {
            return ResponseEntity.ok(trainService.findById(id));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("관광지 리스트를 불러내는데 실패하였습니다.",e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            return ResponseEntity.ok(trainService.delete(id));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("관광지 리스트를 불러내는데 실패하였습니다.",e);
        }
    }

    @PatchMapping("/{id}")
    public TrainDTO update(@PathVariable Long id, @RequestBody TrainDTO trainDTO){
        return trainService.update(id,trainDTO);
    }

}
