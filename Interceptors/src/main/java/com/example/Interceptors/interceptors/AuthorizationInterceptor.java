package com.example.Interceptors.interceptors;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthorizationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
            String userRole = request.getHeader("x-user-role");
            System.out.println("current user role : " + userRole);
            if (userRole == null || !userRole.equals("ADMIN")) {
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                response.setContentType("application/json");
                response.getWriter().write(
                        "\n" +
                                "{\n" +
                                "    \"message\" : \"you are not authoriated to perform this operation\"\n" +
                                "}"
                );
                return false;
        }
        return true;
    }
}
