package org.example.Notification;

public class SmsService implements NotificationService {

    @Override
    public void SendNotification(){
        System.out.println("sms notification send");
    }
}
