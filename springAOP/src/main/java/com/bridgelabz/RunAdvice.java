package com.bridgelabz;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
@EnableAspectJAutoProxy
public class RunAdvice {
    @Before("execution(public void eat())")
    public void run() {
        System.out.println("running ................");
    }
}
