package org.example.get;

import org.example.model.Employee;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

public class GetPOJOWithHeaderExample {
    static final String URL_PATH = "http://localhost:8080/employees";

    public static void main(String[] args) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(new MediaType[]{MediaType.APPLICATION_XML}));

        headers.setContentType(MediaType.APPLICATION_XML);
        headers.set("my_key", "my_value");

        HttpEntity<Employee[]> entity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Employee[]> response = restTemplate.exchange(URL_PATH, HttpMethod.GET, entity, Employee[].class);

        HttpStatus statusCode = response.getStatusCode();
        System.out.println("Response status code: " + statusCode);

        if (statusCode == HttpStatus.OK) {
            Employee[] list = response.getBody();

            if (list != null) {
                for (Employee e : list) {
                    System.out.println("Employee: " + e.getEmpNo() + " - " + e.getEmpName());
                }
            }
        }
    }
}
