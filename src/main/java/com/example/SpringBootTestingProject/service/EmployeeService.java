package com.example.SpringBootTestingProject.service;

import com.example.SpringBootTestingProject.entity.Employee;
import com.example.SpringBootTestingProject.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public Employee addEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public Employee searchByID(Long id) {
        List<Employee> employees = employeeRepo.findAll();
        Employee employee = null;
        for (Employee emp : employees
        ) {
            if (emp.getId() == id)
                employee = emp;
        }
        return employee;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    public void deleteAll() {
        employeeRepo.deleteAll();
    }

    public List<Employee> getEmployeeByName(String name) {
        List<Employee> employees = employeeRepo.findByName(name);
        return employees;
    }
}
