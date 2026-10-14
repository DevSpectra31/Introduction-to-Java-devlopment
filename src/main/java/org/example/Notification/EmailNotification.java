package org.example.Notification;

public class EmailNotification  implements  NotificationService{
   @Override
    public  void SendNotification(){
       System.out.println("email notification send");
   }
}
