package com.bynow.rei.third.rabbitmq.config;

import com.bynow.rei.core.cache.EhcacheFactory;
import com.bynow.rei.core.util.CodeUtil;
import com.bynow.rei.core.util.SerializeUtil;
import com.bynow.rei.third.mail.SendMailUtil;
import com.bynow.rei.third.rabbitmq.dto.EmailMessage;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 15:33 2018/5/3
 */
@Configuration
@AutoConfigureAfter(RabbitMqConfig.class)
public class ExampleAmqpConfiguration {
    @Bean("emailQueueContainer")
    public MessageListenerContainer messageListenerContainer(ConnectionFactory connectionFactory) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames("EMAILQUEUE");
        container.setMessageListener(exampleListener());
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        return container;
    }


    //回调
    @Bean("emailQueueListener")
    public ChannelAwareMessageListener exampleListener() {
        return new ChannelAwareMessageListener() {
            @Override
            public void onMessage(Message message, Channel channel) throws Exception {
                EmailMessage emailMessage = (EmailMessage) SerializeUtil.unserialize(message.getBody());
                String code = CodeUtil.generateUpperString(4);
                SendMailUtil.sendEmail(code,emailMessage.getEmail());
                //缓存用户名与验证码
                EhcacheFactory.getInstance().put("EMAILCACHE",emailMessage.getUsername(),code);
                channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
            }
        };
    }

}