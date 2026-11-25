package org.example.Repository;

import org.example.Model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class StudentRepositroy {

    String url = "jdbc:mysql://localhost:3306/jdbc_intro";
    String username = "root";
    String password = "3108";

    public void addStudent(Student student){
        String sql = """ 
                       INSERT INTO Student(name,email,age) VALUES (?,?,?)
                        """;
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement=connection.prepareStatement(sql);
             ) {
                preparedStatement.setString(1,student.getName());
                preparedStatement.setString(2,student.getEmail());
                preparedStatement.setInt(3,student.getAge());
                int rowaffected = preparedStatement.executeUpdate();
                if(rowaffected == 1){
                    System.out.println("creation successfully");
                }
                else{
                    System.out.println("creation failed");
                }
    } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("database connection failed");
        }
    }
    public void updateUser(Student student, long id){
        String sql = """
                        UPDATE Student
                        SET name = ?,
                        email = ?,
                        age = ?
                        where id = ?;
                        """;
        try(Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            {
                preparedStatement.setString(1,student.getName());
                preparedStatement.setString(2,student.getEmail());
                preparedStatement.setInt(3,student.getAge());
                preparedStatement.setLong(4,id);
                int rowsaffected = preparedStatement.executeUpdate();
                if(rowsaffected == 1){
                    System.out.println("updation successfully");
                }
                else{
                    System.out.println("updation failed");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("database connection failed");
        }
    }
    public void deleteUser(long id){
        String sql = """
                        DELETE FROM Student
                        where id = ? """;
        try(Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
                System.out.println("database connected successfully");
                preparedStatement.setLong(1,id);
                int rowsaffected = preparedStatement.executeUpdate();
                if(rowsaffected == 1){
                    System.out.println("delettion operation successfully");
                }
                else{
                    System.out.println("deletion successfully");

            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("database connection failed");
        }
    }
    public void getUserById(long id){
        String sql = """
                        SELECT * From Student
                        where id = ? """;
        try( Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            {
                System.out.println("database connected successfully");
                preparedStatement.setLong(1, id);
                try(ResultSet resultSet = preparedStatement.executeQuery()){
                    if(resultSet.next()){
                        Student student = mapRow(resultSet);
                        System.out.println(student);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("database connection failed");
        }
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

    public void getStudent(){
        String sql = """
                 SELECT  id , name , email , age FROM Student """;
        try(Connection connection = DriverManager.getConnection(url,username,password);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ){
            System.out.println("data connected successuflly");
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                List<Student> studentList = new ArrayList<>();
                while(resultSet.next()){
                    Student student = mapRow(resultSet);
                    studentList.add(student);
                }
                System.out.println("list of student : " + studentList);
            }
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("database connection failed");
        }
    }
    private Student mapRow(ResultSet resultSet) throws SQLException {
        Student student = new Student();
        student.setId(resultSet.getLong("id"));
        student.setName(resultSet.getString("name"));
        student.setEmail(resultSet.getString("email"));
        student.setAge(resultSet.getInt("age"));
        return student;
    }
}
