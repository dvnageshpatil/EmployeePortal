package com.employee.model;

import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
@Data
public class Employee{
    @Id
    @Field("_id")
    private Integer id;
    private String name;
    private Double salary;
}
