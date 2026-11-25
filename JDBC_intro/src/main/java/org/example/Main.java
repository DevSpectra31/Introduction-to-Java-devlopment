package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.example.Model.Student;
import org.example.Repository.StudentRepositroy;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() throws SQLException {
        StudentRepositroy studentRepositroy = new StudentRepositroy();
//        studentRepositroy.addStudent(new Student("raman","ramanj@gmail.com",23));
//        studentRepositroy.updateUser(new Student("rachit","rahitj@gmail.com",33),7);
//        studentRepositroy.deleteUser(6);
//        studentRepositroy.getUserById(3);
//        studentRepositroy.getStudent();

    }
}
