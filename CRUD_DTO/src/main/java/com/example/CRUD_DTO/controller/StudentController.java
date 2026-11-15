package com.example.CRUD_DTO.controller;


import com.example.CRUD_DTO.entity.Student;
import com.example.CRUD_DTO.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }
    public ResponseEntity<Student> createstudent(@RequestBody  Student studentreq){
        Student studentres = studentService.createStudent(studentreq);

        if(studentres == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(studentres);
    }
}
