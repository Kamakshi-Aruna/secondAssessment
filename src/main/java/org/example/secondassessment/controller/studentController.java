package org.example.secondassessment.controller;

import org.example.secondassessment.model.Student;
import org.example.secondassessment.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class studentController {
    @Autowired
    studentService service;

// Inserting the data
    @PostMapping
    @ResponseBody
    public String insertStudent(@RequestBody Student student) {
           service.insertData(student);
           return "Data Inserted Successfully!!";
    }

//  Fetching the data using id
    @GetMapping("/{id}")
    public Optional<Student> fetchData(@PathVariable String id){
       return  service.fetchData(id);
    }
// Fetch all the data
    @GetMapping
    public List<Student> fetchAllData(){
        return service.fetchAllData();
    }

//   Fetch all the data
    @DeleteMapping("/{id}")
    public String deleteData(@PathVariable String id){
        return service.deleteData(id);
    }
//  Delete the data using id
    @DeleteMapping
    public String deleteAllData(){
       return  service.deleteAllData();
    }
// Update the data
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable String id, @RequestBody Student student){
         Student data=service.updateData(id,student);
         return ResponseEntity.ok(data);

    }

}
