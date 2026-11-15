package org.example;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component

public class OrderService {
    private PaymentService paymentService;

    public OrderService(@Lazy PaymentService paymentService){
        this.paymentService=paymentService;
        System.out.println("orderservice created");
    }
    public void placeorder(){
        System.out.println("place order");
    }
    public void getOrderDetials(){
        System.out.println("get order detials");
    }
}
