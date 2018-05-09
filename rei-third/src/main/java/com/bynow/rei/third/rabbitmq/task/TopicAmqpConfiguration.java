package com.bynow.rei.third.rabbitmq.task;

import com.bynow.rei.core.util.SerializeUtil;
import com.bynow.rei.third.rabbitmq.config.RabbitMqConfig;
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
 * @Date: created in 15:53 2018/5/3
 */
@Configuration
@AutoConfigureAfter(RabbitMqConfig.class)
public class TopicAmqpConfiguration {

    @Bean("topicTest1Container")
    public MessageListenerContainer messageListenerContainer(ConnectionFactory connectionFactory) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames("TOPICTEST1");
        container.setMessageListener(exampleListener1());
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        return container;
    }


    @Bean("topicTest1Listener")
    public ChannelAwareMessageListener exampleListener1(){
        return new ChannelAwareMessageListener() {
            @Override
            public void onMessage(Message message, Channel channel) throws Exception {
               // channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);

            }
        };
    }

}
