package org.example.Notification;

public class PopUpNotification implements  NotificationService{
    @Override
    public void SendNotification(){
        System.out.println("Popup notification send");
    }
}
