package com.kyg.rabbitmqdemo.ttl;

/**
 * @author: kongyigang
 * @Title: constant
 * @ProjectName: rabbitmq-demo
 * @Description:
 * @date: 2021/8/26 4:37 下午
 */
public interface Constant {

    //正常队列名称
    String NORMAL_QUEUE_A = "QA";

    String NORMAL_QUEUE_B = "QB";

    String NORMAL_QUEUE_C = "QC";

    //死信队列名称
    String DEAD_QUEUE = "QD";

    //正常交换机名称
    String NORMAL_EXCHANGE = "X";

    //死信交换机名称
    String DEAD_EXCHANGE = "Y";

    //路由键
    String ROUTE_KEY_A = "XA";

    String ROUTE_KEY_B = "XB";

    String ROUTE_KEY_C = "XC";

    String ROUTE_KEY_D = "YD";

}
