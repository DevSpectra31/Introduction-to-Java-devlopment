package org.example;

import org.springframework.stereotype.Component;

@Component
public class UserService {

    private EmailService emailService;

    public UserService(EmailService emailService){
        this.emailService=emailService;
        System.out.println("user service created");
    }

    public void registerUser(){
        System.out.println("user registered");
        emailService.SendEmail();
    }
}
