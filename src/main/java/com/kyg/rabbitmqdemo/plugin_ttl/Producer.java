package com.kyg.rabbitmqdemo.plugin_ttl;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: kongyigang
 * @Title: Producer
 * @ProjectName: rabbitmq-demo
 * @Description: 消费者
 * @date: 2021/8/27 10:23 下午
 */
@Service(value = "plugin-producer")
public class Producer implements Constant,TtlService {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Override
    public void customTtlService(String message, Integer time) {
        rabbitTemplate.convertAndSend(DELAYED_EXCHANGE,DELAYED_ROUTING_KEY,message,msg -> {
            msg.getMessageProperties().setDelay(time);
            return msg;
        });
    }
}
