package org.example.secondassessment.repository;

import org.example.secondassessment.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface studentRepository extends MongoRepository<Student, String> {
}
