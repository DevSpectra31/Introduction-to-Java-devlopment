package org.example.payment;

public class CardPaymentService implements  PaymentService{
    @Override
    public void pay(){
        System.out.println("paying via card");
    }
}
