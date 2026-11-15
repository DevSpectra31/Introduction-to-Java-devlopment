package org.example;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class OrderService {

    public OrderService(){
        System.out.println("order service created");
    }
public void palceorder(){
    System.out.println("order placed");
}
}
