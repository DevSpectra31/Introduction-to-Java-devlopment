package org.example.Payment;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


//@Component
//@Qualifier("upi")
public class UPIPayment implements  PaymentService{
    @Override
    public  void Pay(){
        System.out.println("Paying via upi");
    }
}
