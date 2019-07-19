package com.bruce.mq;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Destination;


@Configuration
public class ActiveMqConfig {


    @Bean(name = "bruceTopic")
    public Destination bruceTopic() {
        return new ActiveMQTopic("VirtualTopic.bruceDestination");
    }
}
