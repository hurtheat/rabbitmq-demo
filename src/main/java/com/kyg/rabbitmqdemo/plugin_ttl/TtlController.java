package com.kyg.rabbitmqdemo.plugin_ttl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: kongyigang
 * @Title: TtlController
 * @ProjectName: rabbitmq-demo
 * @Description: 发送延时消息的控制层接口
 * @date: 2021/8/27 10:31 下午
 */
@RestController(value = "plugin-controller")
public class TtlController {

    @Autowired
    TtlService ttlService;

    @GetMapping("/plugin-ttl/{msg}/{time}")
    public void sendMsg(@PathVariable("msg") String message,
                        @PathVariable("time") Integer time) {
        ttlService.customTtlService(message,time);
    }
}
