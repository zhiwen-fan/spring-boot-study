package com.bruce.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.jms.Destination;


@RestController
public class MqSender {

    @Resource(name = "bruceTopic")
    private Destination destination;

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @GetMapping(value = "/send")
    public void sendMsg(String msg) {

        jmsMessagingTemplate.convertAndSend(destination,msg);
    }
}
