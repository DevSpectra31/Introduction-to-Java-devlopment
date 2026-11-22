package com.example.AOP.Service;

import com.example.AOP.DTO.Student;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class LoggingDecorator implements StudentService {

    private final StudentServiceImpl studentService;
    public LoggingDecorator(StudentServiceImpl studentService){
        this.studentService=studentService;
    }

    @Override
    public void saveStudent(Student student) {

        LoggingServiceUtil.logstartstart("StudentServiceImpl","saveStudent");
        studentService.saveStudent(student);
        LoggingServiceUtil.logsends("StudentService" , "saveStudent");
    }
}
