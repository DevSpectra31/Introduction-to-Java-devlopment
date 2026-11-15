package com.example.Notification;

import com.example.Notification.impl.NotificationChannel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NotificationApplication {
	private NotificationChannel notificationChannel;
	public NotificationApplication(NotificationChannel notificationChannel){
		this.notificationChannel=notificationChannel;
	}
	public static void main(String[] args) {
		SpringApplication.run(NotificationApplication.class, args);
		No
	}

}
