package com.example.SpringBootTestingProject.repo;

import com.example.SpringBootTestingProject.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {
//    @Query("SELECT e FROM Employee e WHERE e.name = :name")
    List<Employee> findByName(String name);
}
