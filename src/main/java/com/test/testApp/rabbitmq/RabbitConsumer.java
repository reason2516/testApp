package com.test.testApp.rabbitmq;

import com.rabbitmq.client.*;

import javax.sound.sampled.Port;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class RabbitConsumer {
    private static final String QUEUE_NAME = "queue_demo";
    private static final String IP_ADDRESS = "rabbitmq.local";
    private static final int PORT = 5672; // rabbitMQ服务端默认端口号
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        Address[] addresses = {
                new Address(IP_ADDRESS, PORT)
        };
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername(USER);
        factory.setPassword(PASSWORD);

        // 这里的链接方式略有不同
        Connection connection = factory.newConnection(addresses);
        // 创建 channel
        Channel channel = connection.createChannel();
        // 设置最多接收的 未被ack的消息的个数
        channel.basicQos(64);
        int i;
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag,
                                       Envelope envelope,
                                       AMQP.BasicProperties properties,
                                       byte[] body)
                    throws IOException {
                System.out.println("receive message :" + new String(body));
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };
        channel.basicConsume(QUEUE_NAME, consumer);

        // 等待回调完成 关闭资源
        TimeUnit.SECONDS.sleep(5);
        channel.close();
        connection.close();
    }
}
