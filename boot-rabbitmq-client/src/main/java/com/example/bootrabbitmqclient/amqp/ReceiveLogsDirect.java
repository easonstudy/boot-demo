package com.example.bootrabbitmqclient.amqp;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.Random;

public class ReceiveLogsDirect {
    private static final String EXCHANGE_NAME = "ex_logs_direct";
    private static final String[] SEVERITIES = {"info", "warning", "error"};

    public static void main(String[] argv) throws java.io.IOException,
            java.lang.InterruptedException {
        try {
            // 创建连接和频道
            ConnectionFactory factory = new ConnectionFactory();
            factory = new ConnectionFactory();
            factory.setHost("120.79.210.194");
            factory.setPort(5672);
            factory.setUsername("admin");
            factory.setPassword("123456");


            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            // 声明direct类型转发器
            channel.exchangeDeclare(EXCHANGE_NAME, "direct");

            String queueName = channel.queueDeclare().getQueue();
            String severity = getSeverity();
            // 指定binding_key
            channel.queueBind(queueName, EXCHANGE_NAME, severity);
            System.out.println(" [*] Waiting for " + severity + " logs. To exit press CTRL+C");

            //DefaultConsumer consumer = new DefaultConsumer(channel);
            //channel.basicConsume(queueName, true, consumer);

            channel.basicConsume(queueName, true, "DemoTag",
                    new DefaultConsumer(channel) {
                        @Override
                        public void handleDelivery(String consumerTag,
                                                   Envelope envelope,
                                                   AMQP.BasicProperties properties,
                                                   byte[] body)
                                throws IOException {
                            String routingKey = envelope.getRoutingKey();
                            String contentType = properties.getContentType();
                            String message = new String(body, "UTF-8");
                            long deliveryTag = envelope.getDeliveryTag();
                            // (process the message components here ...)
                            System.out.println("Receive===> routingKey:" + routingKey + ", contentType:" + contentType + ", message:" + message);
                            channel.basicAck(deliveryTag, false);
                        }
                    });
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 随机产生一种日志类型
     *
     * @return
     */
    private static String getSeverity() {
        Random random = new Random();
        int ranVal = random.nextInt(3);
        return SEVERITIES[ranVal];
    }

}
