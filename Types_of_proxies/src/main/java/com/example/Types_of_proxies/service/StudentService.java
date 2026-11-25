package com.example.Types_of_proxies.service;

import com.example.Types_of_proxies.DTO.Student;
import jdk.jfr.Timestamp;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Timestamp
    public Student savedStudent(Student student){

        System.out.println("student saved in db");
        return student;
    }

    public String getStudent(String s){
        return s;
    }
    public int dummy(){
        return 0;
    }
}
