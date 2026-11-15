package org.example.service;

import org.example.Entity.Student;
import org.example.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    public Student createStudent(Student studentreq){
        Student studentres = studentRepository.save(studentreq);

        return studentres;
    }

    public Student getonestudent(Long id){
        return (Student) studentRepository.getById(id);
    }

    public List<Student> getallstudent(){
        return  studentRepository.getall();
    }
}
