package com.hui.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 日志记录公共代码
 */
@Component("logger")
@Aspect
public class logger {
    @Pointcut("execution(* *..*.*(..)))")
    private void ptl(){

    }
    /**
     * 前置通知
     */
    @Before("ptl()")
    public void beforePrintLog(){
        System.out.println("前置通知 Logger 前置 before方法记录日志");
    }
    /**
     * 后置通知
     */
    @AfterReturning
    public void afterReturningPrintLog(){
        System.out.println("后置通知 Logger类中afterReturning 方法记录日志");
    }
    /**
     * 异常通知
     */
    @AfterThrowing
    public void aferThrowingPrintLog(){
        System.out.println("异常通知 Logger类中aferThrowingPrintLog 方法记录日志");
    }
    /**
     * 最终通知
     */
    @After("ptl()")
    public void afterPrintLog(){
        System.out.println("最终通知 Logger类中afterPrintLog 方法记录日志");
    }

    /**
     * 环绕通知
     */
    @Around("ptl()")
    public void aroundPringLog(ProceedingJoinPoint pjp){
        Object rtValue = null;
        try {
            Object[] args = pjp.getArgs(); //得到方法执行所需要的参数
            //前置
            rtValue = pjp.proceed();//明确调用切入点方法
            //后置


        } catch (Throwable throwable) {
            //异常
            throwable.printStackTrace();
        }finally {
            //最终
        }
    }
}
