package com.introtospring.introduction.implementation;

import com.introtospring.introduction.Notification;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Qualifier("emailnotif")
@ConditionalOnProperty(name = "notification", havingValue = "email")
@Component
public class EmailNotificatiion implements Notification {
    @Override
    public void send(String message){
        System.out.println("Email in inbox ..." + message);
    }
}
