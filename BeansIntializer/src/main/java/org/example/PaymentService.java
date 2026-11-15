package org.example;

import jdk.jfr.Label;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class PaymentService {
    private OrderService orderService;

    public PaymentService(OrderService orderService){
        this.orderService=orderService;
        System.out.println("payment service created");
    }
}
