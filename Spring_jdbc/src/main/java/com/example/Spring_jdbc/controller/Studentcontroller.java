package com.example.Spring_jdbc.controller;


import com.example.Spring_jdbc.model.Student;
import com.example.Spring_jdbc.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class Studentcontroller {

     private final StudentService studentService;
     public Studentcontroller(StudentService studentService){
         this.studentService=studentService;
     }
    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody Student student){
        studentService.savedStudent(student);
        return ResponseEntity.ok("student saved successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable long id){
         return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudent(){
         return ResponseEntity.ok(studentService.getAllStudents());
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable long id,@RequestBody Student student){
         studentService.updateStudent(id,student);
         return ResponseEntity.ok("student updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable  long id){
         studentService.deleteStudentById(id);
         return ResponseEntity.ok("student deleted");
    }
}
