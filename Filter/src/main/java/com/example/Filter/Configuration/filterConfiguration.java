package com.example.Filter.Configuration;

import com.example.Filter.Filter.DummyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration

public class filterConfiguration {
    @Bean
    public FilterRegistrationBean<DummyFilter> getDummyFilterBean(){
        FilterRegistrationBean<DummyFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new DummyFilter());
        registrationBean.addUrlPatterns("/api/*");
        return registrationBean;
    }
}
