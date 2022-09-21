package com.example.planergram.travelContents.service;

import com.example.planergram.travelContents.model.Platform;
import com.example.planergram.travelContents.repository.PlatformRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

@Service
public class TrainApiService {

    @Autowired
    private PlatformRepository platformRepository;

    public String TrainAPI(String start,String end,String date) throws IOException {

        Platform startPoint = platformRepository.findByNodeName(start);
        String encStartPoint = startPoint.getNodeId();
        Platform endPoint = platformRepository.findByNodeName(end);
        String encEndPoint = endPoint.getNodeId();
        String encDate = date;

        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1613000/TrainInfoService/getStrtpntAlocFndTrainInfo"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + "gRWXz35hiq0Nl5bRB261M0wPTw3y4ovFXJQp9ZMHkQs%2BFph6tyNQtSsIPfodg%2F71NVWs%2F7IM2Y7bidlFnIxqOw%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("_type", "UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*데이터 타입(xml, json)*/
        urlBuilder.append("&" + URLEncoder.encode("depPlaceId", "UTF-8") + "=" + URLEncoder.encode(encStartPoint, "UTF-8")); /*출발기차역ID [상세기능3. 시/도별 기차역 목록조회]에서 조회 가능*/
        urlBuilder.append("&" + URLEncoder.encode("arrPlaceId", "UTF-8") + "=" + URLEncoder.encode(encEndPoint, "UTF-8")); /*도착기차역ID [상세기능3. 시/도별 기차역 목록조회]에서 조회 가능*/
        urlBuilder.append("&" + URLEncoder.encode("depPlandTime", "UTF-8") + "=" + URLEncoder.encode(encDate, "UTF-8")); /*출발일(YYYYMMDD)*/
        urlBuilder.append("&" + URLEncoder.encode("trainGradeCode", "UTF-8") + "=" + URLEncoder.encode("00", "UTF-8")); /*차량종류코드*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println("==================================================");
        System.out.println("==================================================");
        System.out.println("==================================================");
        System.out.println("==================================================");
        System.out.println(sb.toString());
        System.out.println("==================================================");
        System.out.println("==================================================");
        System.out.println("==================================================");
        System.out.println("==================================================");
        System.out.println("==================================================");
        return "이클립스 콘솔창 확인하기";
    }
}
