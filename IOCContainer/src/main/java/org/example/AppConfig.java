package org.example;


import org.example.Payment.CardPayment;
import org.example.Payment.PaymentService;
import org.example.Payment.UPIPayment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;

@Configuration
//@ComponentScan("org.example")
public class AppConfig {
    @Bean
    public User CreateUser(){
        return new User("Vineet", 23);
    }
    @Bean
    public CartService CreateCartService(){
        return new CartService();
    }
    @Bean
    @Qualifier("card")
    public PaymentService createCardPayment(){
        return new CardPayment();
    }
    @Bean
    @Qualifier("upi")
    public PaymentService createUPIPayment(){
        return new UPIPayment();
    }
    @Bean
    public OrderService createOrderService(@Qualifier("card") PaymentService paymentService){
        return new OrderService(paymentService);
    }
}
