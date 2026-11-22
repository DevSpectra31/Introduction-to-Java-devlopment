package com.example.AOP_Advice.service;


import com.example.AOP_Advice.dto.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public Student savedStudent(Student student) throws Throwable{
        System.out.println("student saved");
        return student;
    }

    public String dummy_method(String name){
        System.out.println("dummy method called");
        return name;
    }
}
