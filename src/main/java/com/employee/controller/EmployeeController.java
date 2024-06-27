package com.employee.controller;

import com.employee.exceptions.EmployeeNotFoundExpection;
import com.employee.model.Employee;
import com.employee.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
@Slf4j
@SuppressWarnings({"unused"})
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee){
        log.info("creating employee::"+employee);
       return new ResponseEntity<>(service.addEmployee(employee), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Integer id){
        log.info("deleting employee::"+id);
        return new ResponseEntity<>(service.deleteEmployee(id), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Integer id,@RequestBody Employee employee){
        log.info("updating employee::"+id);
        return new ResponseEntity<>(service.updateEmployee(id,employee), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllEmployees(){
        log.info("Getting all employees");
        return new ResponseEntity<>(service.getAllEmployees(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?>getEmployee(@PathVariable Integer id) throws EmployeeNotFoundExpection {
        log.info("Getting an employee::"+id);
        return new ResponseEntity<>(service.getEmployee(id), HttpStatus.OK);
    }

}
