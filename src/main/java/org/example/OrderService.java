package org.example;

import org.example.Notification.EmailNotification;
import org.example.Notification.NotificationService;
import org.example.Notification.PopUpNotification;
import org.example.Notification.SmsService;

public class OrderService {
    NotificationService notificationService ;
    public  OrderService(NotificationService notificationService){
        this.notificationService = notificationService;
    }
    public OrderService(){

    }
    public void placeOrder(){
        System.out.println("Order Serviced");
        notificationService.SendNotification();
    }

    public void setNotificationService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }
}
