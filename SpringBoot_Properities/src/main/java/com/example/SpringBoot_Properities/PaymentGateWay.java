package com.example.SpringBoot_Properities;

import org.springframework.stereotype.Component;

@Component
public class PaymentGateWay {
    private PaymentProperities paymentProperities;
    public PaymentGateWay (PaymentProperities paymentProperities){
        this.paymentProperities=paymentProperities;
    }

    public String GetType(){
        return paymentProperities.getType();
    }

    public int GetRetryCount(){
        return paymentProperities.getRetrycount();
    }

    public boolean GetEnabled(){
        return paymentProperities.isEnabled();
    }

    public int Gettimeout(){
        return paymentProperities.getTimeout();
    }

    public void print(){

        System.out.println(GetType());
        System.out.println(GetRetryCount());
        System.out.println(GetEnabled());
        System.out.println(Gettimeout());
    }
}
