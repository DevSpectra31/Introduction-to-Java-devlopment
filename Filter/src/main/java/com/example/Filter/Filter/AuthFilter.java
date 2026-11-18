package com.example.Filter.Filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order(2)
public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest serveletrequest, ServletResponse serveletresponse, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) serveletrequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) serveletresponse;

        String token = httpServletRequest.getHeader("token");
        String apikey=httpServletRequest.getHeader("x-api-key");

        if(token == null ){
            httpServletResponse.setStatus(401);
            return ;
        }

        if(apikey == null || !apikey.equals("scret123")){
            httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            httpServletResponse.setContentType("application/json");
            httpServletResponse.getWriter().write(
                    "{\n" +
                            "    \"message\" : \"invalid api key\"\n" +
                            "}"
            );
            return;
        }

        chain.doFilter(httpServletRequest,httpServletResponse);
    }
}
