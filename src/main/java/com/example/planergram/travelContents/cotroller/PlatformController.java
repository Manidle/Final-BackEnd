package com.example.planergram.travelContents.cotroller;

import com.example.planergram.Response.ResponseService;
import com.example.planergram.travelContents.service.PlatformService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"프론트에서 기차 정류장역을 보이게 할 API"})
@RequestMapping("/api")
@RestController
public class PlatformController {

    @Autowired
    PlatformService platformService;

    @ApiOperation(value = "기차 정류장역을 보이게 할 API")
    @GetMapping("/v1/list/nodename")
    public ResponseEntity<?> findAll() {
        try {
            return ResponseEntity.ok(platformService.findAll());
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("기차 정류장역을 부르는데 실패하였습니다.", e);
        }
    }
}
