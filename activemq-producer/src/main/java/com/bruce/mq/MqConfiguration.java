package com.bruce.mq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;

@Configuration
public class MqConfiguration {

    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory () {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL("failover:(tcp://10.11.64.163:61611)?randomize=true&jms.prefetchPolicy.queuePrefetch=5&timeout=2000&maxReconnectAttempts=2&startupMaxReconnectAttempts=1");
        connectionFactory.setSendTimeout(2000);
        connectionFactory.setConnectResponseTimeout(2000);
        connectionFactory.setTrustAllPackages(true);

        return connectionFactory;
    }

    @Bean
    JmsTemplate jmsTemplate(ConnectionFactory connectionFactory) {
        return new JmsTemplate(connectionFactory);
    }
}
