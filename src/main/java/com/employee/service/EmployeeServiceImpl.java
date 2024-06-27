package com.employee.service;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import com.employee.util.EmployeeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

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

    @Override
    public String deleteEmployee(Integer id) {
         repository.deleteById(id);
         return "Successfully deleted the employee";
    }

    @Override
    public Employee updateEmployee(Integer id, Employee employee) {
         Employee e = repository.findById(id).orElseThrow(()->new RuntimeException("Employee not found with id::"+id));
         return repository.save(employee);
    }

    @Override
    public Employee getEmployee(Integer id) {
        return repository.findById(id).orElseThrow(()->new RuntimeException("Employee not found with id::"+id));
    }
    @Override
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }


}
