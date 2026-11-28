package com.example.Hibernate_in_springboot.reppository;


import com.example.Hibernate_in_springboot.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository
public class StudentRepository {
    @PersistenceContext
    private EntityManager entityManager;

    //create
    public void saveStudent(Student student){
        entityManager.persist(student);
    }

    //read
    public Student getStudentbyid(long id){
        return entityManager.find(Student.class,id);
    }
    //delete
    public void deleteStudent(Student student){
        entityManager.remove(student);
    }
}
