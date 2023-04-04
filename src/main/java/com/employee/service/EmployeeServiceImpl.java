package com.employee.service;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import com.employee.util.EmployeeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private EmployeeUtil employeeUtil;

    @Override
    public Employee addEmployee(Employee employee) {
        employee.setId(employeeUtil.generateSequence(Employee.SEQUENCE_NAME));
        return repository.save(employee);
    }
}
