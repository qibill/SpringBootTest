package com.qibill.aop;

import com.qibill.common.utils.JsonUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * Created by sam on 16/11/21.
 */
@Aspect
@Component
public class LogAop {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogAop.class);

    @Around("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
        StringBuilder sbf = new StringBuilder();
        sbf.append("---------------").append("\n");
        sbf.append("Kind:\t").append(pjp.getKind()).append("\n");
        sbf.append("Target\t").append(pjp.getTarget().toString()).append("\n");
        Object[] os = pjp.getArgs();
        sbf.append("Args:").append("\n");
        for (int i = 0; i < os.length; i++) {
            sbf.append("\t==>input[").append(i).append("]:\t").append(os[i] == null ? "" : os[i].toString()).append("\n");
        }
        sbf.append("Signature:\t").append(pjp.getSignature()).append("\n");
        sbf.append("SoruceLocation:\t").append(pjp.getSourceLocation()).append("\n");
        sbf.append("StaticPart:\t").append(pjp.getStaticPart()).append("\n");
        Object retVal = pjp.proceed();
        sbf.append("Result:\t").append(retVal == null ? "" : JsonUtil.objectToJson(retVal)).append("\n");
        sbf.append("-----------------").append("\n");

        LOGGER.info(sbf.toString());
        return retVal;
    }
}
