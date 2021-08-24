package com.kyg.rabbitmqdemo.simple_queue;

import com.rabbitmq.client.*;

import java.nio.charset.StandardCharsets;

/**
 * @author: kongyigang
 * @Title: Producer
 * @ProjectName: rabbitmq-demo
 * @Description:生产者
 * @date: 2021/8/24 10:11 下午
 */
public class Producer {
    public static final String CHANNELNAME = "helloWorld";
    public static void main(String[] args) throws Exception{
        //连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("user");
        connectionFactory.setPassword("password");

        //工厂创建连接
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();

        //生成队列
        channel.queueDeclare(CHANNELNAME,false,false,false,null);

        //发送信息
        String message = "hello world";
        channel.basicPublish("",CHANNELNAME,null,message.getBytes());
        System.out.println("发送信息完成...");
    }
}

