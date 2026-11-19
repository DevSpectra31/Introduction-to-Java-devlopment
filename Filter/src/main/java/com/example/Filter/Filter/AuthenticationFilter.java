package com.example.Filter.Filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
//
//@Component
public class AuthenticationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest serveletrequest, ServletResponse serveletresponse, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) serveletrequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) serveletresponse;

        String token = httpServletRequest.getHeader("token");
        if(token == null || !token.equals("12345")){
            httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            httpServletResponse.setContentType("application/json");
            httpServletResponse.getWriter().write(
                    "{\n" +
                            "    \"message\" : \"Authenication is required\"\n" +
                            "}"
            );
        }
        chain.doFilter(httpServletRequest,httpServletResponse);
    }
}
