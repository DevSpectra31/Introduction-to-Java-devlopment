package org.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

    @Autowired
    private   PaymentService paymentService;
    public OrderService(){
        System.out.println("orderservice created");
    }

    public void PlaceOrder(){
        System.out.println("order placed");
        paymentService.Pay();
    }
}
