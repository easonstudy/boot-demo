package com.example.rabbitmq.web;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @RequestMapping("/direct/{routingKey}/{msg}")
    public String say(@PathVariable("routingKey") String routingKey, @PathVariable("msg") String msg) {
        rabbitTemplate.convertAndSend(routingKey, msg);

        return "0";
    }

    @RequestMapping("/direct/{msg}")
    public String say2(@PathVariable("msg") String msg) {
        rabbitTemplate.convertAndSend("hello", msg);
        return "0";
    }
}
