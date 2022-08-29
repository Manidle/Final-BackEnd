package com.example.planergram.controller;

import com.example.planergram.DTO.RentCarDTO;
import com.example.planergram.DTO.ResponseDTO;
import com.example.planergram.model.RentCar;
import com.example.planergram.service.RentCarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class RentCarController {

    @Autowired
    private RentCarService rentCarService;

    // 렌트카 등록
    @PostMapping("/rentcar/register")
    public ResponseEntity<?> save(@RequestBody RentCarDTO rentCarDTO) {
        try {
            RentCar newRentCar = rentCarService.save(rentCarDTO);
            RentCarDTO newRentCarDTO = rentCarService.makeRentCarDTO(newRentCar);
            return ResponseEntity.ok(newRentCarDTO);
        } catch (Exception e) {
            log.error("렌트카 등록에 실패했습니다." + e.getMessage());
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }

    // 렌트카 조회
    @GetMapping("/rentcar/findall")
    public ResponseEntity<?> findAll() {
        List<RentCar> rentCarList = rentCarService.findAll();
        List<RentCarDTO> rentCarDTOList = new ArrayList<>();
        for (RentCar rentCar : rentCarList) {
            rentCarDTOList.add(
                    RentCarDTO
                            .builder()
                            .rentCarId(rentCar.getRentCarId())
                            .address(rentCar.getAddress())
                            .companyName(rentCar.getCompanyName())
                            .carSort(rentCar.getCarSort())
                            .carName(rentCar.getCarName())
                            .build()
            );
        }
        return ResponseEntity.ok(rentCarDTOList);
    }

    // 렌트카 업데이트
    @PutMapping("/rentcar/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id,@RequestBody RentCarDTO updateRentCarDTO) {
        try {
            RentCar newRentCar = rentCarService.update(id,updateRentCarDTO);
            RentCarDTO rentCarDTO = rentCarService.makeRentCarDTO(newRentCar);
            return ResponseEntity.ok(rentCarDTO);
        } catch (Exception e) {
            log.error("렌트카 업데이트를 실패하였습니다." + e.getMessage());
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }

    // 렌트카 삭제
    @DeleteMapping("/rentcar/remove/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        try {
            RentCar newRentCar = rentCarService.delete(id);
            RentCarDTO rentCarDTO = rentCarService.makeRentCarDTO(newRentCar);
            return ResponseEntity.ok(rentCarDTO);
        } catch (Exception e) {
            log.error("렌트카 삭제에 실패했습니다." + e.getMessage());
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }
}