package com.bynow.rei.third.rabbitmq.task;

import com.bynow.rei.core.util.SerializeUtil;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 15:55 2018/5/3
 */
public class TopicAmqpConfiguration2 {
    @Bean("topicTest2Container")
    public MessageListenerContainer messageListenerContainer(ConnectionFactory connectionFactory) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames("TOPICTEST2");
        container.setMessageListener(exampleListener());
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        return container;
    }


    @Bean("topicTest2Listener")
    public ChannelAwareMessageListener exampleListener() {
        return new ChannelAwareMessageListener() {
            @Override
            public void onMessage(Message message, Channel channel) throws Exception {
               // channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
            }
        };
    }
}
