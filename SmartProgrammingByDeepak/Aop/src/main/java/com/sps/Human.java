package com.sps;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
@EnableAspectJAutoProxy
public class Human {
    
    @Before("execution(public void study())")
    public void wakeUp() {
        System.out.println("Good Morning!");
    }
}
