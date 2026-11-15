package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() throws Exception {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

//        OrderService orderService = context.getBean(OrderService.class);
//        orderService.placeorder();
//        AppConfig appConfig = context.getBean(AppConfig.class);
//        appConfig.Demo();
        CartService cart = context.getBean(CartService.class);
        cart.start();
        System.out.println(cart.GetVal(1));
        cart.AddToCart();
        cart.close();
        System.out.println(cart.GetVal(1));
    }
}
