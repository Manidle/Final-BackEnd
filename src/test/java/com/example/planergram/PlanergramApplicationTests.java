package com.example.planergram;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@SpringBootTest
class PlanergramApplicationTests {

    private static final String URL = "http://localhost:8080/api/auth/v1/post/1";
    private static final String GET = "GET";
    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String DATA = "test data";

//    43.201.21.160:8080
	@Test
	void contextLoads() throws IOException {
        URL url = new URL(URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod(GET);
        connection.setRequestProperty("User-Agent", USER_AGENT);
        connection.setRequestProperty("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJjb3PthqDtgbAiLCJuaWNrbmFtZSI6Iuq4gOuhnOumrCIsImlkIjoxLCJleHAiOjE2NjM2OTA1NzMsInVzZXJuYW1lIjoiZHVkcmhrZDY1NTAifQ.rMjrabrhxkWzFt1vWhrllpcqoAe5h0rEbfR1qhnFq1ZokYLJbjP13eamtx-5PiiqfMXaGHDkVlRp4MNNkLPzzQ");

        int responseCode = connection.getResponseCode();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuffer stringBuffer = new StringBuffer();
        String inputLine;

        while ((inputLine = bufferedReader.readLine()) != null)  {
            stringBuffer.append(inputLine);
        }
        bufferedReader.close();

        String response = stringBuffer.toString();
        System.out.println(response);
	}
}