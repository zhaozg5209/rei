package com.bynow.rei.core.rabbitmq;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 16:01 2018/4/30
 */
@Component
public class Consumers {
    @RabbitListener(
            //1.rabbitAdmin:RabbitAdmin名称
            admin = "rabbitAdmin",
            bindings = @QueueBinding(
                    //1.test.demo.send:队列名,2.true:是否长期有效,3.false:是否自动删除
                    value = @Queue(value = "test.demo.send", durable = "true", autoDelete = "false"),
                    //1.default.topic交换器名称(默认值),2.true:是否长期有效,3.topic:类型是topic
                    exchange = @Exchange(value = "default.topic", durable = "true", type = "topic"),
                    //test2.send:路由的名称,ProducerConfig 里面 绑定的路由名称(xxxx.to(exchange).with("test2.send")))
                    key = "test2.send")
    )
    public void test(Object obj) {
        System.out.println("receive....");
        System.out.println("obj:" + obj.toString());
    }
}
