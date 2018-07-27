package com.example.rabbitmq.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 描述: 接收者
 * @author: yanpenglei
 * @create: 2017/10/25 0:49
 */
@Component
public class DirectReceiver {

    @RabbitListener(queues = "direct")
    @RabbitHandler
    public void process(String message) {
        System.out.println("接收者 DirectReceiver1," + message);
    }
}
