package org.example.controller;
import org.example.Entity.Student;
import org.example.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    @PostMapping("/create")
    public ResponseEntity<Student> createstudent(@RequestBody Student student){
        Student studentres = studentService.createStudent(student);
        if(studentres == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(201).body(studentres);
    }

    @GetMapping("/getone/{id}")
    public ResponseEntity<Student> getone(@PathVariable("id") Long id){
        Student studentres = studentService.getonestudent((long) Math.toIntExact(id));
        if(studentres == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(studentres);
    }

    @GetMapping("/getall")
    public List<Student> getall(){
        return  studentService.getallstudent();
    }
}
