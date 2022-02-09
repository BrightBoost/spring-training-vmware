package com.examplesecurity.demosecurity;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class DemoService {
    @Scheduled(cron="1 * * * *")
    public void doServiceStuff() {
        System.out.println("Great service");
    }
}
