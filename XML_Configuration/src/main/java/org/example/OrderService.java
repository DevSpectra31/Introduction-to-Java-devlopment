package org.example;

import org.example.payment.PaymentService;


public class OrderService {
    private PaymentService paymentService;

//    public void setPaymentService(PaymentService paymentService) {
//        this.paymentService = paymentService;
//    }

       public OrderService(PaymentService paymentService){
        System.out.println("orderservice created");
        this.paymentService=paymentService;
    }
    public void placeOrder(){
        paymentService.pay();
        System.out.println("order placed");
    }
}
