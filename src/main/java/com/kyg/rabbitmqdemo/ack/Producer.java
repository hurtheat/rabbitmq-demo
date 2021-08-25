package com.kyg.rabbitmqdemo.ack;

import com.kyg.rabbitmqdemo.utils.RabbitMQConnectionUtil;
import com.rabbitmq.client.Channel;

import java.util.Scanner;

/**
 * @author: kongyigang
 * @Title: Producer
 * @ProjectName: rabbitmq-demo
 * @Description: 消息确认机制生产者
 * @date: 2021/8/25 3:49 下午
 */
public class Producer {
    public static final String CHANNELNAME = "ack_channel";
    public static void main(String[] args) throws Exception{
        Channel channel = RabbitMQConnectionUtil.createChannel();

        //声明队列
        channel.queueDeclare(CHANNELNAME,false,false,false,null);

        //手动输入所要发送的消息
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入要发送的消息");
        while (scanner.hasNext()) {
            String message = scanner.next();

            //发送消息
            channel.basicPublish("",CHANNELNAME,null,message.getBytes());
            System.out.println(message + "已经发送...");
        }
    }
}
