package org.example.delete;

import org.example.model.Employee;
import org.springframework.web.client.RestTemplate;

public class DeleteExample {
    static final String URL_FOR_DELETE = "http://localhost:8080/employee/E99";

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        Employee employeeForDelete = restTemplate.getForObject(URL_FOR_DELETE, Employee.class);
         if (employeeForDelete!=null){
             System.out.println("Deleted employee: " + employeeForDelete.getEmpNo() + " - " + employeeForDelete.getEmpName());
         }

        restTemplate.delete(URL_FOR_DELETE);

        Employee e = restTemplate.getForObject(URL_FOR_DELETE, Employee.class);
        if (e != null) {
            System.out.println("Deleted employee: " + e.getEmpNo() + " - " + e.getEmpName());
        } else {
            System.out.println("Employee not found!");
        }

    }
}
