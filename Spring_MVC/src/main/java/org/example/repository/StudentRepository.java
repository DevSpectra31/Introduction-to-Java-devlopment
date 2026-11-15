package org.example.repository;

import org.example.Entity.Student;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StudentRepository {

    private Map<Long, Student> studentdb;

    public StudentRepository(){
        studentdb = new HashMap<>();
    }

    public Student save(Student studentreq){
        studentdb.put( studentreq.getId(),studentreq);

        return studentreq;
    }

    public Student getById(Long id){
        Student studentres = studentdb.get(id);
        return studentres;
    }

    public List<Student> getall(){
        return new ArrayList<>(studentdb.values());
    }
}
