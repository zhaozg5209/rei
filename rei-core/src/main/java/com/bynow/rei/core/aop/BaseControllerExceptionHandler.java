package com.bynow.rei.core.aop;

import com.bynow.rei.core.base.tips.ErrorTip;
import com.bynow.rei.core.exception.ReiException;
import com.bynow.rei.core.exception.ReiExceptionEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 全局的的异常拦截器（拦截所有的控制器）（带有@RequestMapping注解的方法上都会拦截）
 *
 * @author fengshuonan
 * @date 2016年11月12日 下午3:19:56
 */
public class BaseControllerExceptionHandler {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * 拦截业务异常
     */
    @ExceptionHandler(ReiException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorTip notFount(ReiException e) {
        log.error("业务异常:", e);
        return new ErrorTip(e.getCode(), e.getMessage());
    }

    /**
     * 拦截未知的运行时异常
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorTip notFount(RuntimeException e) {
        log.error("运行时异常:", e);
        return new ErrorTip(ReiExceptionEnum.SERVER_ERROR.getCode(), ReiExceptionEnum.SERVER_ERROR.getMessage());
    }

}
