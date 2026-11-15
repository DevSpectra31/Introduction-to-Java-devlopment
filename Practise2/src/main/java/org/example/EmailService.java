package org.example;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class EmailService {

    public EmailService(){
        System.out.println("email service created");
    }

    public void SendEmail(){
        System.out.println("email is send");
    }
}
