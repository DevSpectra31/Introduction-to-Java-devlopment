package com.example.Spring_jdbc.service;

import com.example.Spring_jdbc.model.Student;
import com.example.Spring_jdbc.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    public void savedStudent(Student student){
        studentRepository.addStudent(student);
    }

    public Student getStudentById(long id){
        return studentRepository.getUserById(id);
    }
    public List<Student> getAllStudents(){
        return studentRepository.getStudent();
    }

    public void updateStudent(long id,Student student){
        studentRepository.updateUser(id, student);
    }

    public void deleteStudentById(long id){
        studentRepository.deleteUser(id);
    }
}
