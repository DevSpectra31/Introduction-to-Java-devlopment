package com.example.CRUD_DTO.service;


import com.example.CRUD_DTO.entity.Student;
import com.example.CRUD_DTO.respository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {


    private StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    public Student createStudent(Student studentreq){
        return studentRepository.save(studentreq);
    }

    public Student getStudentById(Long id){
        return  studentRepository.getReferenceById(id);
    }
}
