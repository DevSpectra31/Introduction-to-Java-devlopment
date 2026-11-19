package com.example.Filter.service;


import com.example.Filter.DTO.Student;
import com.example.Filter.DTO.StudentResponseDto;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public StudentResponseDto CreateStudent(Student student) {

        StudentResponseDto studentResponseDto=new StudentResponseDto();
        studentResponseDto.setName(student.getName());
        studentResponseDto.setMessage("student saved successfully");
        return  studentResponseDto;
    }
}
