package com.ma.raymond.rayment.services;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MQSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String queue, String message) {

        this.rabbitTemplate.convertAndSend(queue, message);
    }
}
