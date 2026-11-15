package com.example.Notification.impl;

import org.springframework.stereotype.Component;

@Component
public class EmailNotification implements  NotificationChannel{

    @Override
    public  void SendNotification(){
        System.out.println("email notfication send");
    }
}
