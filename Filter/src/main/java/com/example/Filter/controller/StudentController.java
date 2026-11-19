package com.example.Filter.controller;

import com.example.Filter.DTO.Student;
import com.example.Filter.DTO.StudentResponseDto;
import com.example.Filter.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/students")
public class StudentController {

    private StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }
    @PostMapping
    public ResponseEntity<StudentResponseDto> createstudent(@RequestBody Student student){
        StudentResponseDto studentResponseDto = new StudentResponseDto();
       studentResponseDto =  studentService.CreateStudent(student);
        return ResponseEntity.ok(studentResponseDto);
    }
}
