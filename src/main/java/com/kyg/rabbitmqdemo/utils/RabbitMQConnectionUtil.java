package com.kyg.rabbitmqdemo.utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author: kongyigang
 * @Title: RabbitMQConnectionUtil
 * @ProjectName: rabbitmq-demo
 * @Description: mq连接工具类
 * @date: 2021/8/25 12:48 下午
 */
public class RabbitMQConnectionUtil {
    public static Channel createChannel() throws Exception{
        //连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("user");
        connectionFactory.setPassword("password");

        //工厂创建连接
        Connection connection = connectionFactory.newConnection();
        return connection.createChannel();
    }
}

