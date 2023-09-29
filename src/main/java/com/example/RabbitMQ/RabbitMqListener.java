package com.example.RabbitMQ;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@EnableRabbit
@Component
public class RabbitMqListener {

    @RabbitListener(queues = "queue1")
    public void processQueue1(String message) {
        System.out.println("Received from queue 1: " + message);
    }

    @RabbitListener(queues = "queue2")
    public void processQueue2(String message) {
        System.out.println("Received from queue 2: " + message);
    }
}

