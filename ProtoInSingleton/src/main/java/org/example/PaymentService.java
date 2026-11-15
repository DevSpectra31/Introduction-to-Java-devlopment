package org.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class PaymentService {
    @Autowired
    private    OrderService orderService;
    public PaymentService(){
        System.out.println("payment service created");
    }
    public void Pay(){
        System.out.println("Payment done");
    }
}
