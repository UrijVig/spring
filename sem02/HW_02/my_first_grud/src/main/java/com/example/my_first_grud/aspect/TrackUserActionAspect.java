package com.example.my_first_grud.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
//@Component
public class TrackUserActionAspect {
    /**
     * Данный метод реализует аспект отслеживания действий пользователя на странице
     * @param joinPoint - использованный метод
     * @param returnedValue - возвращённое значение
     */
    @AfterReturning(value = "@annotation(TrackUserAction)", returning = "returnedValue")
    public void trackActionLog(JoinPoint joinPoint, Object returnedValue){
        String methodName = joinPoint.getSignature().getName();
        String methodArgs = joinPoint.getArgs()[0].toString();
        System.out.printf("""
                Был вызван метод %s\s
                с переданными в него параметрами:\s
                %s%n""", methodName, methodArgs);
    }
}
