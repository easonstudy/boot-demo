package com.example.bootrabbitmqclient.amqp;

import com.rabbitmq.client.*;

import java.io.IOException;

public class ReceiveHandler {

    private String exchangeName = "directExchange";
    private String queueName = "hello";
    private String routingKey = "12345678";

    private ConnectionFactory factory = null;

    public ReceiveHandler() {
    }

    public ReceiveHandler(String queue) {
        this.queueName = queue;
    }

    private void initFactory() {
        if (factory == null) {
            factory = new ConnectionFactory();
            factory.setHost("120.79.210.194");
            factory.setPort(5672);
            factory.setUsername("admin");
            factory.setPassword("123456");
        }
    }


    public void start() {


        try {
            System.out.println("======Receive start======");
            initFactory();

            new Thread(() -> {
                try {
                    while (true) {
                        Thread.sleep(200);
                        //创建连接,绑定消费
                        Connection conn = factory.newConnection();
                        //开启一个通道
                        Channel channel = conn.createChannel();
                        //通道绑定 exchange的对应queue的 routingKey
                        channel.queueBind(queueName, exchangeName, routingKey);

                        boolean autoAck = false;
                        channel.basicConsume(queueName, autoAck, "DemoTag",
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

                        //channel.close();
                        //conn.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {

                }
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void destory() {

    }

}
