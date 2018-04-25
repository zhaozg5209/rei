package com.bynow.rei;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * rei Web程序启动类
 *
 * @author fengshuonan
 * @date 2017-05-21 9:43
 */
public class ReiServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ReiApplication.class);
    }
}
