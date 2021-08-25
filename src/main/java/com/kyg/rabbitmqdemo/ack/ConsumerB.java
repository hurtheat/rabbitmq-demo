package com.kyg.rabbitmqdemo.ack;

import com.kyg.rabbitmqdemo.utils.RabbitMQConnectionUtil;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

/**
 * @author: kongyigang
 * @Title: Consumer
 * @ProjectName: rabbitmq-demo
 * @Description: 消息确认消费者B
 * @date: 2021/8/25 3:59 下午
 */
public class ConsumerB {
    public static final String CHANNELNAME = "ack_channel";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMQConnectionUtil.createChannel();

        //消费成功后的回调接口
        DeliverCallback deliverCallback = (tag, delivery) ->  {
            //模仿生产上，代码逻辑负责，处理时间较短,休眠1s
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //模仿消息被消费
            System.out.println(new String(delivery.getBody()));

            //手动确定消息被消费,第一个参数是消息的标识，第二个参数表示是否批量确定
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(),false);
        };

        //取消消费的回调接口
        CancelCallback cancelCallback = (tag) -> {
            System.out.println("取消消费...");
        };

        //手动确定消息,注意要将自定确定关闭
        channel.basicConsume(CHANNELNAME,false,deliverCallback,cancelCallback);

    }
}
