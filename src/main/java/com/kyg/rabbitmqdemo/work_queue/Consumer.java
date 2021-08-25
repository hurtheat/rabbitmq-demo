package com.kyg.rabbitmqdemo.work_queue;

import com.kyg.rabbitmqdemo.utils.RabbitMQConnectionUtil;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

/**
 * @author: kongyigang
 * @Title: Consumer
 * @ProjectName: rabbitmq-demo
 * @Description: 工作队列消费者
 * @date: 2021/8/25 12:52 下午
 */
public class Consumer {
    public static final String CHANNELNAME = "helloWorld";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMQConnectionUtil.createChannel();

        //消费成功后的回调接口
        DeliverCallback deliverCallback = (s, delivery) ->  {
            System.out.println("C1消费了消息："+ new String(delivery.getBody()));
        };

        //取消消费的回调接口
        CancelCallback cancelCallback = (s) -> {
            System.out.println("取消消费...");
        };
        channel.basicConsume(CHANNELNAME,false,deliverCallback,cancelCallback);
    }
}
