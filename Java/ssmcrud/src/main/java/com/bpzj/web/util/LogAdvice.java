package com.bpzj.web.util;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAdvice {
    public static Logger loggerAdvice = Logger.getLogger(LogAdvice.class);

    // 只切入Service层和Controller层，不切入DAO和Domain，所以改用xml配置
    // @Around("execution(* com.bpzj.web..*(..))")
    public Object aroundLog(ProceedingJoinPoint pjp) {
        Object result = null;
        // 获取 切入方法 的名称
        String methodName = pjp.getSignature().getName();
        // 获取 切入类 的名称
        String className = pjp.getTarget().getClass().getName();

        try {
            // 用在最后相减，获得一个时间差，认为是数据库操作的时间
            long begin = System.currentTimeMillis();
            // 执行切入方法
            result = pjp.proceed();
            //
            long end = System.currentTimeMillis();
            int ResponseTime = (int) (end - begin);
            String msg = " Weaving\t" + className + "." + methodName + "() ";
            loggerAdvice.info(msg + "\t response time is: " + ResponseTime +"ms");
        } catch (Throwable e) {
            // 异常通知
            loggerAdvice.error(e);
            throw new RuntimeException(e);
        }

        return result;
    }
}
