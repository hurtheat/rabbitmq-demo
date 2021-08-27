package com.kyg.rabbitmqdemo.plugin_ttl;

/**
 * @author: kongyigang
 * @Title: TtlService
 * @ProjectName: rabbitmq-demo
 * @Description: 延时队列服务接口
 * @date: 2021/8/27 10:20 下午
 */
public interface TtlService {

    /*
     * @Description: 自定义时间延时队列服务
     * @param: message
     * @param: time
     * @return void
     * @date 2021/8/27 10:22 下午
    */
    void customTtlService(String message,Integer time);
}
