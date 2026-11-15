package com.example.Filter.service;


import com.example.Filter.DTO.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public void CreateStudent(Student student){

        System.out.println("student saved");
        System.out.println(student.getName());
        System.out.println(student.getEmail());
    }
}
