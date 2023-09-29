package com.example.RabbitMQ;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class SampleController {

    private final RabbitTemplate template;

    public SampleController(RabbitTemplate template) {
        this.template = template;
    }

    @PostMapping("/emit")
    public ResponseEntity<String> emit(@RequestBody Map<String, String> map) {
        System.out.println("Emit to queue");
        template.setExchange("direct-exchange");
        template.convertAndSend(map.get("key"), map.get("message"));
        return ResponseEntity.ok("Success emit to queue");
    }
}