package com.bynow.rei.third.rabbitmq.config.enumsetting;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 14:36 2018/5/3
 */
public class RabbitMqEnum {
    /**
     * @param
     * @Author:chenhf
     * @Description:定义数据交换方式
     * @Date:下午4:08 2017/10/23
     * @return
     */
    public enum Exchange {
        CONTRACT_FANOUT("CONTRACT_FANOUT", "消息分发"),
        CONTRACT_TOPIC("CONTRACT_TOPIC", "消息订阅"),
        CONTRACT_DIRECT("CONTRACT_DIRECT", "点对点");

        private String code;
        private String name;

        Exchange(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public String getName() {
            return name;
        }
    }

    /**
     * describe: 定义队列名称
     * creat_user: chenhf
     * creat_date: 2017/10/31
     **/
    public enum QueueName {
        TESTQUEUE("TESTQUEUE", "测试队列"),
        TOPICTEST1("TOPICTEST1", "topic测试队列"),
        TOPICTEST2("TOPICTEST2", "topic测试队列");

        private String code;
        private String name;

        QueueName(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

    }

    /**
     * describe: 定义routing_key
     * creat_user: chenhf
     * creat_date: 2017/10/31
     **/
    public enum QueueEnum {
        TESTQUEUE("TESTQUEUE1", "测试队列key"),
        TESTTOPICQUEUE1("*.TEST.*", "topic测试队列key"),
        TESTTOPICQUEUE2("lazy.#", "topic测试队列key");


        private String code;
        private String name;

        QueueEnum(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public String getName() {
            return name;
        }
    }
}
