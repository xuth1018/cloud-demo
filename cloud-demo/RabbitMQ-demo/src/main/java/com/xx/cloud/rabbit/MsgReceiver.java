package com.xx.cloud.rabbit;

import com.xx.cloud.config.RabbitConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = RabbitConfig.QUEUE_A)
public class MsgReceiver {

    public static Logger logger = LoggerFactory.getLogger(MsgReceiver.class);

    @RabbitHandler
    public void process(@Payload String content){
        logger.info("接收处理队列A中的消息:{}"+content);
    }

}
