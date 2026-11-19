package com.example.Filter.Filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;
//@Component
public class ResponseHeaderfilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse)  response;
        String requestid = UUID.randomUUID().toString();
        httpServletResponse.setHeader("X-request-Id" , requestid);

        chain.doFilter(request,response);
    }
}
