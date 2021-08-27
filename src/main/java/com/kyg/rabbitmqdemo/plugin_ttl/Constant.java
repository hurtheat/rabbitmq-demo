package com.kyg.rabbitmqdemo.plugin_ttl;

/**
 * @author: kongyigang
 * @Title: Constant
 * @ProjectName: rabbitmq-demo
 * @Description: 常量接口
 * @date: 2021/8/27 10:01 下午
 */
public interface Constant {

    //延时交换机的名称
    String DELAYED_EXCHANGE = "delayed_exchange";

    //延时队列名称
    String DELAYED_QUEUE = "delayed_queue";

    //routing_key
    String DELAYED_ROUTING_KEY = "delayed_routing_key";
}
