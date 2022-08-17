package com.api_rest_backend_spring_boot.app.controller;

import com.api_rest_backend_spring_boot.app.exceptions.ResourceNotFoundException;
import com.api_rest_backend_spring_boot.app.models.Employee;
import com.api_rest_backend_spring_boot.app.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
            Employee employee = employeeRepository.findById(id)
                    .orElseThrow(()->new ResourceNotFoundException("The employee not exists in the id " + id));
            return ResponseEntity.ok(employee);
    }
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployees(@PathVariable Long id,@RequestBody Employee updatedEmployee){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("The employee not exists in the id " + id));

        employee.setName(updatedEmployee.getName());
        employee.setLastname(updatedEmployee.getLastname());
        employee.setEmail(updatedEmployee.getEmail());

        Employee employeeUpdate = employeeRepository.save(employee);

        return ResponseEntity.ok(employee);
    }
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("The employee not exists in the id " + id));

        employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
