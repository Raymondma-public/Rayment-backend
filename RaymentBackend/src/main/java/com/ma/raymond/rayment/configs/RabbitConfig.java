package com.ma.raymond.rayment.configs;

import com.ma.raymond.rayment.constants.PaymentMQ;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean("QUEUE_NETWORK_PAYMENT_RSP_H")
    public Queue Queue() {
        return new Queue(PaymentMQ.QUEUE_NETWORK_PAYMENT_RSP_H);
    }

}