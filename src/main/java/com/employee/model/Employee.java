package com.employee.model;

import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Employee{
    @Id
    private Integer id;
    private String name;
    private Double salary;
}
