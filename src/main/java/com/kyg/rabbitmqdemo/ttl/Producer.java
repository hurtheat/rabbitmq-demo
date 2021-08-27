package com.kyg.rabbitmqdemo.ttl;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: kongyigang
 * @Title: Producer
 * @ProjectName: rabbitmq-demo
 * @Description: 延时队列生产者
 * @date: 2021/8/27 3:38 下午
 */
@Service
public class Producer implements Constant, TtlService {

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void ttlQueueA(String message) {
        rabbitTemplate.convertAndSend(NORMAL_EXCHANGE,ROUTE_KEY_A,message);
    }

    public void ttlQueueB(String message) {
        rabbitTemplate.convertAndSend(NORMAL_EXCHANGE,ROUTE_KEY_B,message);
    }

    public void ttlQueueC(String message,String time) {
        rabbitTemplate.convertAndSend(NORMAL_EXCHANGE,ROUTE_KEY_C,message,msg -> {
            msg.getMessageProperties().setExpiration(time);
            return msg;
        });
    }
}
