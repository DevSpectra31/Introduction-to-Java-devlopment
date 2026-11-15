package com.example.Profiling;


import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"prod","staging"})
public class NotificationserviceImplementation implements NotificationService{

    @Override
    public String send() {
        return "notification is send";
    }
}
