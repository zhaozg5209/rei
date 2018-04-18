package com.bynow.rei.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Bynow
 * @Date 2018/04/18
 */
@SpringBootApplication
public class ReiApplication {

    private final static Logger logger = LoggerFactory.getLogger(ReiApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ReiApplication.class, args);
        logger.info("ReiApplication is success!");
    }
}
