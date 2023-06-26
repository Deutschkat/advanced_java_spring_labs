package platform.codingnomads.co.aspectorientedprogramming.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomLogAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomLogAspect.class);

    @Before("@annotation(customLog)")
    public void logCustomMessage(JoinPoint joinPoint, CustomLog customLog) {
        LOGGER.info("Executing Method : " + joinPoint.getSignature().getName() + ". Custom Message : " + customLog.message());
    }
}