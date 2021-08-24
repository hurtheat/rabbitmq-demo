package com.kyg.rabbitmqdemo.simple_queue;

import com.rabbitmq.client.*;

/**
 * @author: kongyigang
 * @Title: Consumer
 * @ProjectName: rabbitmq-demo
 * @Description: 消费者
 * @date: 2021/8/24 11:21 下午
 */
public class Consumer {
    public static final String CHANNELNAME = "helloWorld";
    public static void main(String[] args) throws Exception {
        //连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("user");
        connectionFactory.setPassword("password");

        //工厂创建连接
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();

        //消费成功后的回调接口
        DeliverCallback deliverCallback = (s, delivery) ->  {
            System.out.println(new String(delivery.getBody()));
        };

        //取消消费的回调接口
       CancelCallback cancelCallback = (s) -> {
           System.out.println("取消消费...");
       };

       //消费消息
       channel.basicConsume(CHANNELNAME,true,deliverCallback,cancelCallback);

    }
}
