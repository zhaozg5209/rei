package com.bynow.rei.core.util;

import com.bynow.rei.config.properties.ReiProperties;

/**
 * 验证码工具类
 */
public class KaptchaUtil {

    /**
     * 获取验证码开关
     */
    public static Boolean getKaptchaOnOff() {
        return SpringContextHolder.getBean(ReiProperties.class).getKaptchaOpen();
    }
}