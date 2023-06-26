package platform.codingnomads.co.aspectorientedprogramming.lab.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingServiceAspect {

    @Pointcut("execution(* platform.codingnomads.co.aspectorientedprogramming.lab.service.GreetingService.goodbye(..))")
    public void goodbyePointcut() {}

    @Before("execution(* platform.codingnomads.co.aspectorientedprogramming.lab.service.GreetingService.greeting(..))")
    public void beforeGreeting(JoinPoint joinPoint) {
        System.out.println("Before");
    }

    @AfterReturning("execution(* platform.codingnomads.co.aspectorientedprogramming.lab.service.GreetingService.greeting(..))")
    public void afterReturningGreeting(JoinPoint joinPoint) {
        System.out.println("After Returning");
    }

    @Before("goodbyePointcut()")
    public void beforeGoodbye(JoinPoint joinPoint) {
        System.out.println("Before Goodbye");
    }

    @AfterReturning("goodbyePointcut()")
    public void afterReturningGoodbye(JoinPoint joinPoint) {
        System.out.println("After Returning Goodbye");
    }
}