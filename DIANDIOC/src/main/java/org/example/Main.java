package org.example;

import org.example.Notification.EmailService;
import org.example.Notification.Notification;
import org.example.Notification.SmsNotification;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        Notification notification = new EmailService();
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        OrderService orderService = new OrderService(notification);
        orderService.placeOrder();
    }
}
