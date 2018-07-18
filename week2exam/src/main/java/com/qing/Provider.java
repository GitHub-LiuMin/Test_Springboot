package com.qing;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * @program: week2exam
 * @description: 生产者
 * @author: 杨国庆
 * @create：2018-07-16 08:46
 **/

public class Provider {

    public static void setRabbitTemplate(RabbitTemplate rabbitTemplate) {
        Provider.rabbitTemplate = rabbitTemplate;
    }

    private static RabbitTemplate rabbitTemplate;

    public static  void send(Object message){
        rabbitTemplate.convertAndSend(message);
    }


}
