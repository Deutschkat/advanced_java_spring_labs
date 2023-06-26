package platform.codingnomads.co.aspectorientedprogramming.lab.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PrintableAspect {

    @Pointcut("@annotation(platform.codingnomads.co.aspectorientedprogramming.lab.aspect.Printable)")
    public void printableMethods() {}

    @Before("printableMethods()")
    public void beforePrintableMethod(JoinPoint joinPoint) {
        System.out.println("Printing method: " + joinPoint.getSignature().getName());
    }

    @AfterReturning("printableMethods()")
    public void afterReturningPrintableMethod(JoinPoint joinPoint) {
        System.out.println("Finished printing method: " + joinPoint.getSignature().getName());
    }
}