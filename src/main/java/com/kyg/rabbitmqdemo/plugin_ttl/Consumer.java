package com.kyg.rabbitmqdemo.plugin_ttl;

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
 * @Description: 消费者
 * @date: 2021/8/27 10:27 下午
 */
@Component(value = "plugin-consumer")
@Slf4j
public class Consumer implements Constant {

    @RabbitListener(queues = DELAYED_QUEUE)
    public void consumer(Message message, Channel channel) {
        log.info("收到消息:" + new String(message.getBody()));
    }
}
