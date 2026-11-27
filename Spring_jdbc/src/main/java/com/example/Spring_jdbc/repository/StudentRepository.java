package com.example.Spring_jdbc.repository;

import com.example.Spring_jdbc.model.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
    JdbcTemplate jdbcTemplate;
    private RowMapper<Student> rowMapper =
            new BeanPropertyRowMapper<>(Student.class);
    String url = "jdbc:mysql://localhost:3306/jdbc_intro";
    String username = "root";
    String password = "3108";

    public StudentRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }
    public void addStudent(Student student){
        String sql = """ 
                       INSERT INTO Student(name,email,age) VALUES (?,?,?)
                        """;
        int rowaffected=jdbcTemplate.update(sql,student.getName(),student.getEmail(),student.getAge());
        if(rowaffected == 1){
            System.out.println("creation successfully");
        }
        else{
            System.out.println("creation failed");
        }

    }
    public void updateUser(long id,Student student){
        String sql = """
                        UPDATE Student
                        SET name = ?,
                        email = ?,
                        age = ?
                        where id = ?;
                        """;
        int rowsaffected=jdbcTemplate.update(sql,student.getName(),student.getEmail(),student.getAge(),id);
        System.out.println(rowsaffected);
        if(rowsaffected == 1){
            System.out.println("updation successfully");
        }
        else{
            System.out.println("updation failed");
        }
    }
    public void deleteUser(long id){
        String sql = """
                        DELETE FROM Student
                        where id = ? """;
            int rowsaffected = jdbcTemplate.update(sql,id);
            if(rowsaffected == 1){
                System.out.println("delettion operation successfully");
            }
            else{
                System.out.println("deletion successfully");

            }
    }
    public Student getUserById(long id){
        String sql = """
                        SELECT * From Student
                        where id = ? """;
        return jdbcTemplate.queryForObject(sql,rowMapper,id);
    }
//    public void completeCRUD(){
//        try {
//            Connection connection = DriverManager.getConnection(url, username, password); {
//                System.out.println("database connected successfully");
//                Statement statement=  connection.createStatement();
//                String sql = "SELECT id,name,email,age from student where  id = 5";
//                boolean result = statement.execute(sql);
//                if(result == true){
//                    ResultSet resultSet = statement.getResultSet();
//                }
//                else{
//                    int rowaffected = statement.getUpdateCount();
//                }
//                connection.close();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            System.out.println("database connection failed");
//        }
//    }

    public List<Student> getStudent(){
        String sql = """
                 SELECT  id , name , email , age FROM Student """;
        return jdbcTemplate.query(sql,rowMapper);
    }
}
