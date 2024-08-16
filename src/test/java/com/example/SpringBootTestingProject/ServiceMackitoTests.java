package com.example.SpringBootTestingProject;

import com.example.SpringBootTestingProject.entity.Employee;
import com.example.SpringBootTestingProject.repo.EmployeeRepo;
import com.example.SpringBootTestingProject.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {ServiceMackitoTests.class})
public class ServiceMackitoTests {

    @Mock
    EmployeeRepo employeeRepo;

    @InjectMocks
    EmployeeService employeeService;


    @Test
    public void test_getAllEmployees() {
        List<Employee> allEmployees = new ArrayList<>();
        allEmployees.add(new Employee(1L, "prajj", 45000, "DC"));
        allEmployees.add(new Employee(2L, "shyam", 25000, "LA"));
        when(employeeRepo.findAll()).thenReturn(allEmployees);
        assertEquals(2, employeeService.getAllEmployees().size());
    }

    @Test
    public void test_getEmployeeByID() {
        List<Employee> employees = new ArrayList<Employee>();
               employees.add(new Employee(1L, "prajj", 45000, "DC"));
                employees.add(new Employee(2L, "crato", 55000, "LS"));
        Long empId = 1L;
        when(employeeRepo.findAll()).thenReturn(employees);
        assertEquals(empId, employeeService.searchByID(empId).getId());
    }

    @Test
    public void test_getEmployeeByName() {
        List<Employee> employees = new ArrayList<Employee>();
               employees.add(new Employee(1L, "prajj", 45000, "DC"));
                employees.add(new Employee(2L, "crato", 55000, "LS"));
        String empRequest = "prajj";
        when(employeeRepo.findAll()).thenReturn(employees);
        List<Employee> empResponse = (List<Employee>) employeeService.getEmployeeByName(empRequest);
        List<Employee> expectedResponse = new ArrayList<>();
        expectedResponse.add(new Employee(1L, "prajj", 45000, "DC"));
        Assertions.assertEquals(empResponse,empResponse);
    }
}
