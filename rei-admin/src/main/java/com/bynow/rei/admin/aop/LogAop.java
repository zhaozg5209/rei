//package com.bynow.rei.admin.aop;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
///**
// * 日志记录
// *
// * @author fengshuonan
// * @date 2016年12月6日 下午8:48:30
// */
//@Aspect
//@Component
//public class LogAop {
//
//    private Logger log = LoggerFactory.getLogger(this.getClass());
//
//    @Pointcut(value = "@annotation(com.stylefeng.guns.core.common.annotion.BussinessLog)")
//    public void cutService() {
//    }
//
//    @Around("cutService()")
//    public Object recordSysLog(ProceedingJoinPoint point) throws Throwable {
//
//        //先执行业务
//        Object result = point.proceed();
//
//        try {
//            handle(point);
//        } catch (Exception e) {
//            log.error("日志记录出错!", e);
//        }
//
//        return result;
//    }
//
//    private void handle(ProceedingJoinPoint point) throws Exception {
//
//
//
//    }
//}