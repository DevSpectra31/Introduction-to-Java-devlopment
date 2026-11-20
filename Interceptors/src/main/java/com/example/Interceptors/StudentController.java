package com.example.Interceptors;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @PostMapping
    public ResponseEntity<String> createstudent(){
        System.out.println("controller called");
        return ResponseEntity.ok("Student creaated");
    }
}
