package com.zhoutong.mongo.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Aoplog {

    @Pointcut()
    public void webLog(){
        System.err.println("AOP");
    }
}
