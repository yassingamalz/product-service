package com.logiclytics.productservice.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingAspect {

    private Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.logiclytics.productservice.controller.*.*(..)) || " +
            "execution(* com.logiclytics.productservice.service.*.*(..))")
    public void logMethodCall(JoinPoint joinPoint) {
        logger.info("Method {}() called with arguments {}", joinPoint.getSignature().getName(), joinPoint.getArgs());
    }
}

