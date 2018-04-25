package com.bynow.rei;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot方式启动类
 *
 * @author bynow
 * @Date 2017/5/21 12:06
 */
@SpringBootApplication
public class ReiApplication {

    private final static Logger logger = LoggerFactory.getLogger(ReiApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ReiApplication.class, args);
        logger.info("reiApplication is success!");
    }
}
