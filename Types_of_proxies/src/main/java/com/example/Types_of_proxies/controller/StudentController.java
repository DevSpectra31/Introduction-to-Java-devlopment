package com.example.Types_of_proxies.controller;


import com.example.Types_of_proxies.DTO.Student;
import com.example.Types_of_proxies.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private  StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){

        return ResponseEntity.ok(studentService.savedStudent(student));
    }
    @GetMapping
    public ResponseEntity<String> getStudent(){
        String s = "All students data";
        return ResponseEntity.ok(studentService.getStudent(s));
    }
}
