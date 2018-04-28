package com.org.hsd.web;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Controller控制层 日志切面类
 */
@Aspect//注解将一个java类定义为切面类
@Component
public class LogAspect {

    private final static Logger logger = LoggerFactory.getLogger(LogAspect.class);

    //定义一个切入点
    @Pointcut("execution(* com.org.hsd.controller..*(..))")
    public void webLog(){
    }
    //方法前执行
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attribute = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attribute.getRequest();
//        logger.info("-------------doBefore()-----------------");
//        //url
//        logger.info("url={}",request.getRequestURI());
//        //method
//        logger.info("method={}",request.getMethod());
//        //ip
//        logger.info("ip={}",request.getRemoteAddr());
//        //类方法
//        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+ "."+joinPoint.getSignature().getName());
//        //参数
//        logger.info("args={}",JSONObject.toJSONString(joinPoint.getArgs()));
    }
    //方法后执行
    @After("webLog()")
    public void doAfter(){
//        logger.info("-------------doAfter()-----------------");
    }

    //获取请求结果
    @AfterReturning(returning = "object" , pointcut = "webLog()")
    public void doAfterReturing(Object object){
//        logger.info("response={}",JSONObject.toJSONString(object));
    }
}
