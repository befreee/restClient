package org.example.post;

import org.example.model.Employee;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class PostEntityExample {
    static final String URL_CREATE_EMPLOYEE = "http://localhost:8080/employee";

    public static void main(String[] args) {
        Employee newEmployee = new Employee("E99", "Katya", "Manager");
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<Employee> requestBody = new HttpEntity<>(newEmployee);

        ResponseEntity<Employee> result = restTemplate.postForEntity(URL_CREATE_EMPLOYEE, requestBody, Employee.class);

        System.out.println("Status code: " + result.getStatusCode());
        if (result.getStatusCode() == HttpStatus.OK) {
            System.out.println("Employee created: " + result.getBody().getEmpNo() + " - " + result.getBody().getEmpName());
        }
    }
}
