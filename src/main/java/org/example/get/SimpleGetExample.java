package org.example.get;

import org.springframework.web.client.RestTemplate;

public class SimpleGetExample {
    static final String URL_PATH = "http://localhost:8080/employees";
    static final String URL_XML = "http://localhost:8080/employees.xml";
    static final String URL_JSON = "http://localhost:8080/employees.json";

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        String response = restTemplate.getForObject(URL_PATH, String.class);
        System.out.println(response);
    }

}
