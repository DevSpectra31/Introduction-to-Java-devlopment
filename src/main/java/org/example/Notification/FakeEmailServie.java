package org.example.Notification;

public class FakeEmailServie implements NotificationService{

    @Override
    public void SendNotification(){
        System.out.println("Dummy email send");
    }
}
