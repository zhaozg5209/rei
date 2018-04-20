package com.bynow.rei.core.log.factory;

import com.bynow.rei.core.log.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.TimerTask;

;

/**
 * 日志操作任务创建工厂
 *
 * @author fengshuonan
 * @date 2016年12月6日 下午9:18:27
 */
public class LogTaskFactory {

    private static Logger logger = LoggerFactory.getLogger(LogManager.class);

    public static TimerTask loginLog(final Integer userId, final String ip) {
        return new TimerTask() {
            @Override
            public void run() {
                try {
                } catch (Exception e) {
                    logger.error("创建登录日志异常!", e);
                }
            }
        };
    }

}
