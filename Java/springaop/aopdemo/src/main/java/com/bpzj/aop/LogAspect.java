package com.bpzj.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

// 把这个类注册到IOC容器中，再声明为一个切面
@Aspect
@Component
public class LogAspect {

    // 前置增强/前置通知
    @Before("execution(public int com.bpzj.aop.CalculateImpl.*(int,int))")
    public void beforeMethod(JoinPoint joinPoint) {
        // 注意参数中的 JoinPoint
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("方法执行前提示:");
        System.out.println("方法" + methodName + "开始执行，参数为：" + args);
    }

    /**
     * 后置增强/后置通知，在切入方法执行后执行，无论切入方法是否发生异常，都执行
     * 在后置通知中不能访问切入方法的执行结果，想访问要在返回通知中访问
     * */
    @After("execution(public int com.bpzj.aop.CalculateImpl.*(int,int))")
    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("方法执行后提示:");
        System.out.println("方法" + methodName + "执行结束");

    }

    /**
     * 返回通知，正常结束后才能执行，出异常无法执行
     * 可以访问切入犯法的返回值
     */
    @AfterReturning(
            value = "execution(public int com.bpzj.aop.CalculateImpl.*(..))",
            returning = "result")
    public void afterRuturning(JoinPoint joinPoint,Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("方法" + methodName + "执行结果为" + result);
    }

    // 参考 aopbyproxy 中的理解
}
