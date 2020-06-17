package com.qibill.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author qibill
 * @date 2020/5/11 10:26
 **/
@Aspect
@Component
public class QuartzJobLogAop {
    private static final Logger LOGGER = LoggerFactory.getLogger(QuartzJobLogAop.class);

    @Around("execution(* executeInternal(..))")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {

        LOGGER.info("Job: [{}] start [{}] ", pjp.getTarget().toString(), LocalDateTime.now());

        Object retVal = pjp.proceed();

        LOGGER.info("Job: [{}] end [{}] ", pjp.getTarget().toString(), LocalDateTime.now());
        return retVal;
    }
}
