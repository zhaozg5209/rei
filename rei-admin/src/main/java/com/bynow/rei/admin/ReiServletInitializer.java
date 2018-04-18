package com.bynow.rei.admin;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * REI WEB启动类
 * @author Bynow
 * @Date 2018/04/18
 */
public class ReiServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ReiApplication.class);
    }
}
