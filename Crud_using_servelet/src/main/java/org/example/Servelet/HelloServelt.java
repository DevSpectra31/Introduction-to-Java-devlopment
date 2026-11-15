package org.example.Servelet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/hello")
public class HelloServelt extends HttpServlet {

    public HelloServelt(){
        System.out.println("constructor called");
    }
    @Override
    public void init(){
        System.out.println("init method called");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setStatus(201);
        response.setContentType("application/json");
        response.getWriter().write("hello");
    }

    @Override
    public void destroy(){
        System.out.println("servelet destroyed");
    }
}
