package com.employee.util;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/*  emp_id sequnce should be created in mongo db compass in database_sequences collection*/
@Document(collection = "database_sequences")
@Data
public class SequenceId {

	@Id
	private String id;

	private Integer seq;

	//get, set, toString...
}