package com.kyg.rabbitmqdemo.ttl;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: kongyigang
 * @Title: RabbitMQConfig
 * @ProjectName: rabbitmq-demo
 * @Description: mq的配置类
 * @date: 2021/8/26 4:31 下午
 */
@Configuration
public class RabbitMQConfig implements Constant{

    //声明延时交换机
    @Bean(DEAD_EXCHANGE)
    public Exchange buildDeadExchange () {
        return ExchangeBuilder.directExchange(DEAD_EXCHANGE).durable(true).build();
    }

    //声明正常交换机
    @Bean(NORMAL_EXCHANGE)
    public Exchange buildNormalExchange () {
        return ExchangeBuilder.directExchange(NORMAL_EXCHANGE).durable(true).build();
    }

    //声明死信队列
    @Bean(DEAD_QUEUE)
    public Queue buildDeadQueue() {
        return QueueBuilder.durable(DEAD_QUEUE).build();
    }

    //声明10s的延时队列
    @Bean(NORMAL_QUEUE_A)
    public Queue buildNormalQueueA() {
        Map<String, Object> argument = new HashMap<>();
        argument.put("x-dead-letter-exchange",DEAD_EXCHANGE);
        argument.put("x-dead-letter-routing-key",ROUTE_KEY_D);
        argument.put("x-message-ttl",10000);
        return QueueBuilder.durable(NORMAL_QUEUE_A).withArguments(argument).build();
    }
    //声明40s的延时队列
    @Bean(NORMAL_QUEUE_B)
    public Queue buildNormalQueueB() {
        Map<String, Object> argument = new HashMap<>();
        argument.put("x-dead-letter-exchange",DEAD_EXCHANGE);
        argument.put("x-dead-letter-routing-key",ROUTE_KEY_D);
        argument.put("x-message-ttl",40000);
        return QueueBuilder.durable(NORMAL_QUEUE_B).withArguments(argument).build();
    }

    @Bean(NORMAL_QUEUE_C)
    public Queue buildNormalQueueC() {
        Map<String, Object> argument = new HashMap<>();
        argument.put("x-dead-letter-exchange",DEAD_EXCHANGE);
        argument.put("x-dead-letter-routing-key",ROUTE_KEY_D);
        return QueueBuilder.durable(NORMAL_QUEUE_C).withArguments(argument).build();
    }

    @Bean
    public Binding bindingNormalQueueA(@Qualifier(NORMAL_QUEUE_A) Queue queueA,
                                       @Qualifier(NORMAL_EXCHANGE) Exchange normalExchange) {
        return BindingBuilder.bind(queueA).to(normalExchange).with(ROUTE_KEY_A).noargs();
    }

    @Bean
    public Binding bindingNormalQueueB(@Qualifier(NORMAL_QUEUE_B) Queue queueB,
                                       @Qualifier(NORMAL_EXCHANGE) Exchange normalExchange) {
        return BindingBuilder.bind(queueB).to(normalExchange).with(ROUTE_KEY_B).noargs();
    }

    @Bean
    public Binding bindingNormalQueueC(@Qualifier(NORMAL_QUEUE_C) Queue queueC,
                                       @Qualifier(NORMAL_EXCHANGE) Exchange normalExchange) {
        return BindingBuilder.bind(queueC).to(normalExchange).with(ROUTE_KEY_C).noargs();
    }

    @Bean
    public Binding bindingDeadQueue(@Qualifier(DEAD_QUEUE) Queue deadQueue,
                                    @Qualifier(DEAD_EXCHANGE) Exchange deadExchange) {
        return BindingBuilder.bind(deadQueue).to(deadExchange).with(ROUTE_KEY_D).noargs();
    }
}
