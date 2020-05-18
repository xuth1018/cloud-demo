package com.xx.cloud.rabbit;

import com.xx.cloud.config.RabbitConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MsgProducer implements RabbitTemplate.ConfirmCallback {

    private static Logger logger = LoggerFactory.getLogger(MsgProducer.class);

    private RabbitTemplate rabbitTemplate;

    @Autowired
    public MsgProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        rabbitTemplate.setConfirmCallback(this);
        //如果rabbittemplate为单例的化，那回调的就是最后设置的内容
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        logger.info("回调id：{}",correlationData);
        if(b){
            logger.info("消费成功");
        }else{
            logger.info("消费失败：",s);
        }
    }

    public void sendMsg(String content){
        CorrelationData data = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_A,RabbitConfig.ROUTINGKEY_A,content,data);
    }
}
