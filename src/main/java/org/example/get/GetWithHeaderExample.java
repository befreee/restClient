package org.example.get;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

public class GetWithHeaderExample {
    static final String URL_PATH = "http://localhost:8080/employees";

    public static void main(String[] args) {

        // HttpHeaders
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(new MediaType[]{MediaType.APPLICATION_JSON}));

        // Request to return JSON format
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("my_key","my_value");
        System.out.println(headers);

        // HttpEntity<String>: To get result as String
        HttpEntity<String> entity = new HttpEntity<>(headers);

        //RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Send request with GET method, and Headers
        ResponseEntity<String> response = restTemplate.exchange(URL_PATH, HttpMethod.GET,entity, String.class);
        String result = response.getBody();
        System.out.println(result);
    }
}
