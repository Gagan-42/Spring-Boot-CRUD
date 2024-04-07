package com.CRUD.Springboot.employeeservice.impl;

import com.CRUD.Springboot.employeeservice.EmployeeService;
import com.CRUD.Springboot.model.Employee;
import com.CRUD.Springboot.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
   private final EmployeeRepository employeeRepository;


    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        Employee employee1 = new Employee();
        employee1.setFirstName(employee.getFirstName());
        employee1.setLastName(employee.getLastName());
        employee1.setEmailId(employee.getEmailId());
        return employeeRepository.save(employee1);
    }

    @Override
    public Employee updateEmployee(long id, Employee employee) {

        Employee employee1 = employeeRepository.findById(id).orElseThrow(()->new RuntimeException("Employee not found"));
        employee1.setFirstName(employee.getFirstName());
        employee1.setLastName(employee.getLastName());
        employee1.setEmailId(employee.getEmailId());
       return employeeRepository.save(employee1);
    }

    @Override
    public void deleteById(long id) {
        employeeRepository.deleteById(id);

    }

    @Override
    public Employee getById(long id) {
        return employeeRepository.findById(id).orElseThrow(()->new RuntimeException("Employee not found"));
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

}
