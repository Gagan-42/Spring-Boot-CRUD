package com.CRUD.Springboot.employeeservice;

import com.CRUD.Springboot.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(Employee employee);
    Employee updateEmployee(long id, Employee employee );
    void deleteById(long id);
    Employee getById(long id);
    List<Employee> getAllEmployees();


}
