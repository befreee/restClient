package org.example.put;

import org.example.model.Employee;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class PutSimpleExample {
    static final String URL_UPDATE_EMPLOYEE = "http://localhost:8080/employee";
    static final String URL_EMPLOYEE_PREFIX = "http://localhost:8080/employee";

    public static void main(String[] args) {

        String empNo = "E03";
        Employee updateEmployee = new Employee(empNo, "Gena", "Looser");
        HttpHeaders headers = new HttpHeaders();

        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);

        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<Employee> requestEntity = new HttpEntity<>(updateEmployee, headers);

        restTemplate.put(URL_UPDATE_EMPLOYEE, requestEntity);

        String resourceURL = URL_EMPLOYEE_PREFIX + "/" + empNo;

        Employee e = restTemplate.getForObject(resourceURL, Employee.class);

        if (e!=null){
            System.out.println("(Client side) Employee after update: ");
            System.out.println("Employee: " + e.getEmpNo() + " - " + e.getEmpName());
        }
    }
}
