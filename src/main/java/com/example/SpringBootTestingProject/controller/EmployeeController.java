package com.example.SpringBootTestingProject.controller;

import com.example.SpringBootTestingProject.entity.Employee;
import com.example.SpringBootTestingProject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/saveEmployee")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @GetMapping("/getByID")
    public ResponseEntity<Object> getByID(@RequestParam Long id) {
        Employee emplID = employeeService.searchByID(id);
        if (emplID == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID does not exist");
        }
        return ResponseEntity.ok(emplID);
    }

    @GetMapping("/getAllEmployees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @DeleteMapping("/deleteAll")
    public String deleteAll(){
        employeeService.deleteAll();
        return "removed everything";
    }

    @GetMapping("/getByName")
    public ResponseEntity<List<Employee>> findByName(@RequestParam String name) {
        List<Employee> employees = employeeService.getEmployeeByName(name);
        return ResponseEntity.ok(employees);
    }
}
