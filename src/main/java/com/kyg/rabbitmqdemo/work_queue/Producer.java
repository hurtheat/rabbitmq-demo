package com.kyg.rabbitmqdemo.work_queue;

import com.kyg.rabbitmqdemo.utils.RabbitMQConnectionUtil;
import com.rabbitmq.client.Channel;

import java.util.Scanner;

/**
 * @author: kongyigang
 * @Title: Producer
 * @ProjectName: rabbitmq-demo
 * @Description: 工作队列生产者
 * @date: 2021/8/25 1:00 下午
 */
public class Producer {
    public static final String CHANNELNAME = "helloWorld";

    public static void main(String[] args) throws Exception{
        Channel channel = RabbitMQConnectionUtil.createChannel();

        //生成队列
        channel.queueDeclare(CHANNELNAME,false,false,false,null);

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入所要发送消息：");
        while (scanner.hasNext()) {
        String message = scanner.next();

        //发送消息
        channel.basicPublish("",CHANNELNAME,false,null,message.getBytes());
        System.out.println("消息发送成功...");
        }

    }
}
