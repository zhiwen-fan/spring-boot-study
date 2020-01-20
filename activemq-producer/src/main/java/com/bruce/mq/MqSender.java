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
        long start = System.currentTimeMillis();
        try {
            jmsMessagingTemplate.convertAndSend(destination,msg);
        }catch (Exception e) {
            long time = System.currentTimeMillis() - start;
            System.out.println("active mq send cost time: " + time);
            e.printStackTrace();
        }
    }

    @GetMapping(value = "/mqspace/test")
    public void sendMultipleMsg() {
        final int[] msg = new int[1000];
        for (int i =0; i< 1000; i++) {
            msg[i] =i;
        }

        jmsMessagingTemplate.convertAndSend(destination,msg.toString());

        for (int i=0; i<1; i++) {
            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            while (true) {
                                jmsMessagingTemplate.convertAndSend(destination,msg.toString());
                                try {
                                    Thread.sleep(200);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
            ).start();
        }

    }
}
