package com.bynow.rei.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Bynow
 * @Date 2018/04/18
 */
@SpringBootApplication
@ComponentScan(basePackages = { "com.bynow"})
@MapperScan("com.bynow.rei.core.module.dao")
public class ReiApplication {

    private final static Logger logger = LoggerFactory.getLogger(ReiApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ReiApplication.class, args);
        logger.info("ReiApplication is success!");
    }
}
