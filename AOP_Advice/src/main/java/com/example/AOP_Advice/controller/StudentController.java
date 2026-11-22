package com.example.AOP_Advice.controller;


import com.example.AOP_Advice.dto.Student;
import com.example.AOP_Advice.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private   StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) throws Throwable {

        Student s = studentService.savedStudent(student);

        return ResponseEntity.ok(s);
    }
    @GetMapping
    public ResponseEntity<String> dummyMethod(){

        return ResponseEntity.ok(studentService.dummy_method("vineet"));
    }
}
