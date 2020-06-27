package com.example.demo20062702.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class CalcAspect {

//    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* com.example.demo20062702..*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("The method "+joinPoint.getSignature().getName()+"() begins with "+Arrays.toString(joinPoint.getArgs()));
       // log.info("The method {}() begins with {} ", joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
    }

}
