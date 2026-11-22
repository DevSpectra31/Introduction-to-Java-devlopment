package com.example.AOP.Service;

import com.example.AOP.DTO.Student;
import com.example.AOP.Repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }
    @Override
    public void saveStudent(Student student)  {

        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }
        studentRepository.save(student);
    }
}
