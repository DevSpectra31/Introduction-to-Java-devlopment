package org.example;

import org.example.Notification.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        NotificationService notificationService = new EmailNotification();
       // OrderService orderService = new OrderService(notificationService);
        OrderService orderService = new OrderService();
        orderService.setNotificationService(notificationService);
        orderService.placeOrder();
    }
}
