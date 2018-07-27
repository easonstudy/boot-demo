package com.example.rabbitmq.direct;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 描述:
 *
 * @author yanpenglei
 * @create 2017-10-25 0:47
 **/
@Component
public class helloReceiver {

   /* @RabbitListener(queues = "hello")
    @RabbitHandler
    public void process(String message) {
        System.out.println("接收者 helloReceiver," + message);
    }*/


    @RabbitListener(queues = "direct")
    @RabbitHandler
    public void bb(String message) {
        System.out.println("接收者 DirectReceiver2," + message);
    }
}
