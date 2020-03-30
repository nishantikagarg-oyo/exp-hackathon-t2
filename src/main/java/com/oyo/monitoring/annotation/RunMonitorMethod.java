package com.oyo.monitoring.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RunMonitorMethod {

    private static final Logger log = LoggerFactory.getLogger(RunMonitorMethod.class);

    @Around("@annotation(MonitorMethod)")
    public void logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String methodName = methodSignature.getName();
        try{
            joinPoint.proceed();
        }catch (Exception e){
            log.info(methodName + e.getMessage());
            throw e;
        }
        log.info("Method - " + methodName + " executed in {} ms", (System.currentTimeMillis() -start));
    }
}
