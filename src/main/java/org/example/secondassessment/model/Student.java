package org.example.secondassessment.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "student")
@Data
public class Student {
    @Id
    private String id;
    private String name;
    private int age;
    private String email;
}
