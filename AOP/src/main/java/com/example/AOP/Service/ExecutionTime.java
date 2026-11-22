package com.example.AOP.Service;

import com.example.AOP.DTO.Student;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class ExecutionTime implements StudentService{

    private LoggingDecorator loggingDecorator;
    public ExecutionTime(LoggingDecorator loggingDecorator){
        this.loggingDecorator=loggingDecorator;
    }
    @Override
    public void saveStudent(Student student) {
        long starttiem = System.currentTimeMillis();

        loggingDecorator.saveStudent(student);
        long endttime =System.currentTimeMillis();

        long duration = endttime-starttiem;

        System.out.println("TSD duration : " + duration);
    }
}
