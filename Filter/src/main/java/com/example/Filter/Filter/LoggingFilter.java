package com.example.Filter.Filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest serveletrequest, ServletResponse serveletresponse, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest)  serveletrequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) serveletresponse;

        System.out.println("incoming request : "+httpServletRequest);
        System.out.println("outgoing request : "+httpServletResponse);

    }


}
