package com.example.Filter.Filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
@Order(1)
public class LoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest serveletrequest, ServletResponse serveletresponse, FilterChain chain) throws IOException, ServletException {

        Long starttime = System.currentTimeMillis();

        HttpServletRequest httpServletRequest = (HttpServletRequest)  serveletrequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) serveletresponse;

        String reqid = UUID.randomUUID().toString();

        httpServletResponse.setHeader("X-Request-ID", reqid);
        System.out.println("incoming request : "+httpServletRequest.getMethod() + httpServletRequest.getRequestURI());

        try {
            chain.doFilter(httpServletRequest,httpServletResponse);
        } finally{
            long duration = System.currentTimeMillis() - starttime;
            System.out.println("outgoing response : " +httpServletResponse.getStatus() );
            System.out.println("Duration of req res : "+duration);

        }


    }


}
