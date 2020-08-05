package com.itheima.anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


@Component("myAspect")
@Aspect  //标注当前Myaspect是一个切面
public class MyAspect {

//    @Before(value = "execution(* com.itheima.anno.*.*(..))")
    public void before(){
        System.out.println("前置增强......");
    }

    public void afterReturning(){
        System.out.println("后置曾倩......");
    }

    @Around("pointcut()")
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
    @After("MyAspect.pointcut()")
    public void after(){
        System.out.println("最终增强..........");
    }

    //定义切点表达式
    @Pointcut("execution(* com.itheima.anno.*.*(..))")
    public void pointcut(){}
}
