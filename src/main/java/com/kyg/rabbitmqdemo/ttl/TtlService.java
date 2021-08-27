package com.kyg.rabbitmqdemo.ttl;

/**
 * @author: kongyigang
 * @Title: ttlService
 * @ProjectName: rabbitmq-demo
 * @Description:
 * @date: 2021/8/27 4:11 下午
 */
public interface TtlService {

    /*
     * @Description: 10s的延时
     * @param: message
     * @return void
     * @date 2021/8/27 4:12 下午
    */
    void ttlQueueA(String message);

    /*
     * @Description: 40s的延时消息
     * @param: message
     * @return void
     * @date 2021/8/27 4:13 下午
    */
    void ttlQueueB(String message);

    /*
     * @Description:存放延时消息的队列,通过指定消息的延时时间实现延时
     * @param: message
     * @param: time
     * @return void
     * @date 2021/8/27 7:10 下午
    */
    void ttlQueueC(String message,String time);
}
