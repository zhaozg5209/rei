package com.bynow.rei.core.rabbitmq;

import com.bynow.rei.modular.system.model.User;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 16:03 2018/4/30
 */
@Component
public class Producters {

    @Resource
    RabbitMessagingTemplate rabbitSendTemplate;

    public void send(User user) {
        System.out.println("send start.....");
        rabbitSendTemplate.convertAndSend("default.topic", "test2.send", user);
    }
}
