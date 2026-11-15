package com.example.SpringBootDemo2;


public class OrderService {
    private  PaymentService paymentService;

    public OrderService(PaymentService paymentService){
        this.paymentService=paymentService;
    }

    public void placeorder(){
        paymentService.pay();
        System.out.println("order placed");
    }
}
