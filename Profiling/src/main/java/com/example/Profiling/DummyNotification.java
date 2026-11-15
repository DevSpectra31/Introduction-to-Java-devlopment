package com.example.Profiling;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"dev","default"})
public class DummyNotification implements  NotificationService{
    @Override
    public String send() {
        return "dummy check for developement process";
    }
}
