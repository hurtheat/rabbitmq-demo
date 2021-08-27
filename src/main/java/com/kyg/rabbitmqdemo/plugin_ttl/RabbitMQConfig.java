package com.kyg.rabbitmqdemo.plugin_ttl;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: kongyigang
 * @Title: RabbittMQConfig
 * @ProjectName: rabbitmq-demo
 * @Description: mq配置类
 * @date: 2021/8/27 9:57 下午
 */
@Configuration(value = "plugin-config")
public class RabbitMQConfig implements Constant {

    //声明延时交换机（安装插件才有效）
    @Bean(DELAYED_EXCHANGE)
    public CustomExchange delayedExchange() {
        Map<String, Object> argument = new HashMap<>();
        argument.put("x-delayed-type","direct");
        return new CustomExchange(DELAYED_EXCHANGE,"x-delayed-message",true,false,argument);
    }

    //声明延时队列
    @Bean(DELAYED_QUEUE)
    public Queue delayedQueue() {
        return QueueBuilder.durable(DELAYED_QUEUE).build();
    }

    @Bean
    public Binding bindingQueue(@Qualifier(DELAYED_QUEUE) Queue delayedQueue,
                                @Qualifier(DELAYED_EXCHANGE) CustomExchange delayedExchange) {
        return BindingBuilder.bind(delayedQueue).to(delayedExchange).with(DELAYED_ROUTING_KEY).noargs();
    }
}
