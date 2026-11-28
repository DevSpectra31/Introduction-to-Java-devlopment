package com.example.Hibernate_in_springboot.controller;

import com.example.Hibernate_in_springboot.model.Student;
import com.example.Hibernate_in_springboot.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/student")
public class StudentController {
    private final StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }
    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody Student student){
        System.out.println("controller called");
        studentService.savedStudent(student);
        return ResponseEntity.ok("student saved successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable long id){
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

//    @GetMapping
//    public ResponseEntity<List<Student>> getAllStudent(){
//        return ResponseEntity.ok(studentService.getAllStudents());
//    }
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
