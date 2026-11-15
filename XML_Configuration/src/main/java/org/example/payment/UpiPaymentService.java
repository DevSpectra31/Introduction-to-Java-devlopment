package org.example.payment;

public class UpiPaymentService implements  PaymentService{

    @Override
    public void pay(){
        System.out.println("paying via upi");
    }
}
