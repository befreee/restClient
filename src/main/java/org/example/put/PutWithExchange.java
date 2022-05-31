package org.example.put;

import org.example.model.Employee;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class PutWithExchange {
    static final String URL_UPDATE_EMPLOYEE = "http://localhost:8080/employee";
    static final String URL_EMPLOYEE_PREFIX = "http://localhost:8080/employee";

    public static void main(String[] args) {
        String empNo = "E02";
        Employee updateEmployee = new Employee(empNo, "Valera", "Winner");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);

        HttpEntity<Employee> requestBody = new HttpEntity<>(updateEmployee, headers);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.exchange(URL_UPDATE_EMPLOYEE, HttpMethod.PUT, requestBody, Employee.class);

        String resourceURL = URL_EMPLOYEE_PREFIX + "/" + empNo;

        Employee e = restTemplate.getForObject(resourceURL, Employee.class);

        if (e != null) {
            System.out.println("(Client side) Employee updated: ");
            System.out.println("Employee: " + e.getEmpNo() + " - " + e.getEmpName());
        }

    }
}
