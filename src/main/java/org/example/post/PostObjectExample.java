package org.example.post;

import org.example.model.Employee;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class PostObjectExample {
    static final String URL_CREATE_EMPLOYEE = "http://localhost:8080/employee";

    public static void main(String[] args) {

        Employee newEmployee = new Employee("E22", "Sanya", "SuperVisor");

        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", MediaType.APPLICATION_XML_VALUE);
        headers.setContentType(MediaType.APPLICATION_XML);

        RestTemplate restTemplate = new RestTemplate();

        // Data attached to the request
        HttpEntity<Employee> requestBody = new HttpEntity<>(newEmployee,headers);

        Employee e = restTemplate.postForObject(URL_CREATE_EMPLOYEE,requestBody,Employee.class);

        if (e!=null&&e.getEmpNo()!=null){
            System.out.println("Employee created: " + e.getEmpNo());
        } else {
            System.out.println("Something going wrong!");
        }

    }
}
