package com.xx.cloud.contoller;

import com.sun.media.jfxmedia.logging.Logger;
import com.xx.cloud.rabbit.MsgProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/order")
@RestController
public class OrderApi {

    @Autowired
    private MsgProducer msgProducer;
    @GetMapping("/order/{content}")
    public String order(@PathVariable String content){
        msgProducer.sendMsg(content);
        System.out.println("发送消息："+content);
        return "1";
    }
}
