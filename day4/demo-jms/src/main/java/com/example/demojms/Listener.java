package com.example.demojms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Listener {

    @JmsListener(destination = "messageBox")
    public void receivingMessage(Message message) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Received: " + message);
    }
}
