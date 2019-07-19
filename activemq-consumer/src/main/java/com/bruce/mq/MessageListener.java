package com.bruce.mq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @JmsListener(destination = "Consumer.bruceTest.VirtualTopic.bruceDestination")
    public void onMessage(String msg) {
        System.out.println("message revieved; " + msg);
    }
}
