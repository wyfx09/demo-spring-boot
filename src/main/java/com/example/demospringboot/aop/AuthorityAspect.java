package com.example.demospringboot.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

@Aspect
@Component
public class AuthorityAspect {

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Pointcut("@annotation(com.example.demospringboot.aop.Authority)")
    public void pointCut() {}

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable{

        Object result = point.proceed();
        String authorityString = httpServletRequest.getHeader("authority");
        System.out.println("http head authority:"+authorityString);

        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        Authority authority = method.getAnnotation(Authority.class);
        if(null != authority){
            System.out.println("authority:"+authority.value());
        }
        return result;
    }

}
