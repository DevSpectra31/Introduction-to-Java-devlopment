package com.example.Filter.Filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;

//@Component
public class ResponseBodyFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;


        ContentCachingResponseWrapper wrapedResponse = new ContentCachingResponseWrapper(httpServletResponse);

        chain.doFilter(request,wrapedResponse);

        byte[] originalBodyRes =   wrapedResponse.getContentAsByteArray();
        String originalBody = new String(originalBodyRes);
        String modifiedbody =
                """
                        {
                        "originalResponse " : %s,
                        "appName " : Student Managemnet System ,
                        }
                        """.formatted(originalBody);
        wrapedResponse.resetBuffer();
        wrapedResponse.getWriter().write(modifiedbody);

        wrapedResponse.copyBodyToResponse();

     }
}
