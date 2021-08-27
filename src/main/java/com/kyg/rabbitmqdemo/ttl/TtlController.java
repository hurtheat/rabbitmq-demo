package com.kyg.rabbitmqdemo.ttl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: kongyigang
 * @Title: ttlController
 * @ProjectName: rabbitmq-demo
 * @Description: 测试延时队列的接口
 * @date: 2021/8/27 4:09 下午
 */
@RestController
public class TtlController {

    @Autowired
    TtlService ttlService;

    @GetMapping("/ttl-a/{msg}")
    public void ttlQueueA(@PathVariable("msg") String message) {
        ttlService.ttlQueueA(message);
    }

    @GetMapping("/ttl-b/{msg}")
    public void ttlQueueB(@PathVariable("msg") String message) {
        ttlService.ttlQueueB(message);
    }

    @GetMapping("/ttl-c/{msg}/{time}")
    public void ttlQueueB(@PathVariable("msg") String message,
                          @PathVariable("time") String time) {
        ttlService.ttlQueueC(message,time);
    }
}
