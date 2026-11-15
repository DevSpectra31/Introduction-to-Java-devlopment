package org.example;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class OrderRequest {

    public OrderRequest(){
        System.out.println("order request created");
    }
}
