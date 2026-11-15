package org.example;

import org.springframework.stereotype.Component;

@Component
public class DashBoardService {

    public DashBoardService(ReportService reportService){
        System.out.println("Dashboard service created");
    }
}
