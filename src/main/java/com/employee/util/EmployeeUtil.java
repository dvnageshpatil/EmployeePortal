package com.employee.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import java.util.Objects;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Repository
public class EmployeeUtil {
    @Autowired
    private MongoOperations mongoOperation;
   public long generateSequence(String seqName) {
       SequenceId counter = mongoOperation.findAndModify(query(where("_id").is(seqName)),
               new Update().inc("seq",1), options().returnNew(true).upsert(true),
               SequenceId.class);
       return !Objects.isNull(counter) ? counter.getSeq() : 1;
   }
}
