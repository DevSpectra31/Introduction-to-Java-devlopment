package org.example;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class ReportService {

    public ReportService(){
        System.out.println("report service created");
    }

    public void GetReport(){
        System.out.println("report generated successfully");
    }
}
