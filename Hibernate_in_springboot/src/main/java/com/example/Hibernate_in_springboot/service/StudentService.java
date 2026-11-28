package com.example.Hibernate_in_springboot.service;

import com.example.Hibernate_in_springboot.model.Student;
import com.example.Hibernate_in_springboot.reppository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.cglib.core.MethodWrapper;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    @Transactional
    public void savedStudent(Student student){
        studentRepository.saveStudent(student);
    }

    public Student getStudentById(long id){
        return studentRepository.getStudentbyid(id);
    }
//    public List<Student> getAllStudents(){
//        return studentRepository.getStudent();
//    }
    @Transactional
    public void updateStudent(long id,Student studentreq){
        Student student1 = studentRepository.getStudentbyid(id);
        student1.setName(studentreq.getName());
        student1.setEmail(studentreq.getEmail());
        student1.setAge(studentreq.getAge());
    }

    @Transactional
    public void deleteStudentById(long id){
        Student student=studentRepository.getStudentbyid(id);
        if (student == null){
            throw new RuntimeException("student not found");
        }

        studentRepository.deleteStudent(student);
    }
}
