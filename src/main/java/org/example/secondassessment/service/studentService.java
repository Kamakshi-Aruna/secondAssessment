package org.example.secondassessment.service;

import org.example.secondassessment.model.Student;
import org.example.secondassessment.repository.studentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class studentService {
    @Autowired
    studentRepository studentRepo;

    public void insertData(Student student) {
         studentRepo.save(student);

    }

    public Optional<Student> fetchData(String id) {
        return studentRepo.findById(id);
    }

    public List<Student> fetchAllData() {
        return studentRepo.findAll();
    }

    public String deleteData(String id) {
        Optional<Student> op=studentRepo.findById(id);
        if(op.isPresent()) {
            studentRepo.deleteById(id);
            return "Data is Deleted";
        }else{
            return "No Data Found";
        }
    }

    public String deleteAllData() {
        List<Student> l=studentRepo.findAll();
        if(l.isEmpty()){
            return "No Data Found!";
        }else{
            for(Student s:l){
                studentRepo.deleteAll();
            }
            return "Data is Deleted";
        }
    }

    public Student updateData(String id, Student student) {
        Optional<Student> op = studentRepo.findById(id);
        if (op.isPresent()) {
            Student std = op.get();
            std.setName(student.getName());
            std.setEmail(student.getEmail());
            std.setAge(student.getAge());
            return studentRepo.save(std);
        } else {
            throw new RuntimeException("User Not Found with id" + id);
        }
    }
}
