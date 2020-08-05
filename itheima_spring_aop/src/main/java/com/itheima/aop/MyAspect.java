package com.itheima.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {


    public void before(){
        System.out.println("前置增强......");
    }

    public void afterReturning(){
        System.out.println("后置曾倩......");
    }

//    ProceedingJoinPoint: 切点（执行中的连接点）
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前增强......");
        //切点方法
        Object proceed = pjp.proceed();
        System.out.println("环绕后增强......");
        return proceed;
    }

    public void afterThrowing(){
        System.out.println("after throwing adviCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCE......");
    }
    public void after(){
        System.out.println("最终增强..........");
    }
}
