package com.kyg.rabbitmqdemo.ttl;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author: kongyigang
 * @Title: Consumer
 * @ProjectName: rabbitmq-demo
 * @Description: 延时队列消费者
 * @date: 2021/8/27 3:38 下午
 */
@Component
@Slf4j
public class Consumer implements Constant{

    @RabbitListener(queues =DEAD_QUEUE)
    public void consumer(Message message, Channel channel) throws IOException {
        log.info("收到消息:" + new String(message.getBody()));
        }
}
