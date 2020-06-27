package com.bridgelabz;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class WalkAdvice {

    @After("execution(public void eat())")
    public void walk() {
        System.out.println("walking...........");
    }
}
