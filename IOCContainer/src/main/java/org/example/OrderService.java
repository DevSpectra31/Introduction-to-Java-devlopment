package org.example;

import org.example.Payment.PaymentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderService {
    private  final PaymentService paymentService ;

//    @Autowired
//    public void setPaymentService(PaymentService paymentService) {
//        this.paymentService = paymentService;
//   }
    // @Autowired
  public OrderService( PaymentService paymentService){
       this.paymentService=paymentService;
    }

    public void placeorder(){
        paymentService.Pay();
        System.out.println("order palced");
    }
}
