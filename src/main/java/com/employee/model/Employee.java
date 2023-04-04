package com.employee.model;

import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "employee")
@Data
public class Employee{


  /*  emp_id sequnce should be created in mongo db compass in database_sequences collection*/
    @Transient
    public static final String SEQUENCE_NAME = "emp_idx";
    @Id
    private Long id;
    private String name;
    private Double salary;
}
