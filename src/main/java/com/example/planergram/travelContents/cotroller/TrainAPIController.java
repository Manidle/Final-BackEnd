package com.example.planergram.travelContents.cotroller;

import com.example.planergram.Response.ResponseService;
import com.example.planergram.travelContents.repository.PlatformRepository;
import com.example.planergram.travelContents.service.TrainApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//프론트 엔드에서 할 작업인데 일단 안지움
@RequestMapping("/api")
@RestController
public class TrainAPIController {

    @Autowired
    private TrainApiService trainApiService;

    @Autowired
    private PlatformRepository platformRepository;

    @GetMapping("/auth/v1/list/trainapi")
    public ResponseEntity<?> TrainAPI(@RequestParam(value = "start") String start,
                                      @RequestParam(value = "end") String end,
                                      @RequestParam(value = "date") String date){
        try {
            return ResponseEntity.ok(trainApiService.TrainAPI(start,end,date));
        } catch (Exception e) {
            return ResponseService.makeResponseEntity("숙소 검색에 실패하였습니다.",e);
        }
    }
}