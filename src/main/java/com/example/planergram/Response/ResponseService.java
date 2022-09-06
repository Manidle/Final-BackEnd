package com.example.planergram.Response;

import com.example.planergram.DTO.ResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;

@Slf4j
public class ResponseService {
    static public ResponseEntity makeResponseEntity(String massage, Exception e){
        log.error("[ERROR] : " + massage + e);
        ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
        return ResponseEntity.badRequest().body(responseDTO);
    }
}
