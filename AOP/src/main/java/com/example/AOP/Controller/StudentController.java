package com.example.AOP.Controller;


import com.example.AOP.DTO.Student;
import com.example.AOP.Service.StudentService;
import com.example.AOP.Service.StudentServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }
    @PostMapping
    public ResponseEntity<String> createStudent(Student student)  {
        studentService.saveStudent(student);

        return ResponseEntity.ok("student saved");
    }
}
