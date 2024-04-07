package com.CRUD.Springboot.controller;

import com.CRUD.Springboot.employeeservice.EmployeeService;
import com.CRUD.Springboot.employeeservice.impl.EmployeeServiceImpl;
import com.CRUD.Springboot.model.Employee;
import com.CRUD.Springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/worker")

public class EmployeeController {

    private final EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);

    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable(name = "id") long id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(name = "id") long id) {
        employeeService.deleteById(id);
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable(name = "id") long id) {
        return employeeService.getById(id);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}
