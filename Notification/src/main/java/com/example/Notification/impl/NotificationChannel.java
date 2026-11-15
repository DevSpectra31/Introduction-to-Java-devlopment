package com.example.Notification.impl;

import org.springframework.stereotype.Component;

@Component
public interface NotificationChannel {
    void SendNotification();
}
