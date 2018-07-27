package com.example.bootrabbitmqclient.amqp;

public class Receive {

    public static void main(String[] args) {

        ReceiveHandler receiver = new ReceiveHandler();
        receiver.start();
    }


}
