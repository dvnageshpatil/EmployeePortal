package com.employee.service;

import com.employee.exceptions.EmployeeNotFoundExpection;
import com.employee.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(Employee employee);
    String deleteEmployee(Integer id);
    Employee updateEmployee(Integer id, Employee employee);
    Employee getEmployee(Integer id) throws EmployeeNotFoundExpection;
    List<Employee> getAllEmployees();
}
