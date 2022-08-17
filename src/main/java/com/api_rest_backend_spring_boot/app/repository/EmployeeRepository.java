package com.api_rest_backend_spring_boot.app.repository;

import com.api_rest_backend_spring_boot.app.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
 
}
