package com.introtospring.introduction.implementation;

import com.introtospring.introduction.Notification;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Qualifier("smsnotify")
@Component
public class SmsNotfication implements Notification {
    @Override
    public void send(String message){
        System.out.println("sms is sending ... "+message);
    }
}
