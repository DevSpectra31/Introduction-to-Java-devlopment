package org.example;

import org.example.Notification.EmailService;
import org.example.Notification.Notification;
import org.example.Notification.SmsNotification;

public class OrderService {
    private  Notification notification ;
    public OrderService(Notification notification){
        this.notification = notification;
    }

    public void placeOrder(){
        System.out.println("Order is placed");
        notification.SendNotification();
    }
}
