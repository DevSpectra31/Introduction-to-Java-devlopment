package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService {
    @Autowired
    private PaymentService paymentService;
//    public OrderService(PaymentService paymentService){
//        this.paymentService=paymentService;
//    }
    public void palceorder(){
        paymentService.pay();
        getOrderDetials();
        System.out.println("order placed");
    }
    public void getOrderDetials(){
        System.out.println("get order details");
    }
}
