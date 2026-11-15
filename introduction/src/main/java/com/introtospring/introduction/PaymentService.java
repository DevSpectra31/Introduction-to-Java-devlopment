package com.introtospring.introduction;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Controller
public class PaymentService {
    public void pay(){
        System.out.println("paying ...");
    }
    @PostConstruct
    public void afterIntail(){
        System.out.println("Befor paying");
    }
    @PreDestroy
    public void beforedestroy(){
        System.out.println("after paying");
    }
}
