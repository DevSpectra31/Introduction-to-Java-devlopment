package com.example.Notification.impl;

import org.springframework.stereotype.Component;

@Component
public class SMSNotification implements  NotificationChannel{

    @Override
    public void SendNotification(){
        System.out.println("sms notification send");
    }
}
