package com.jsonyao.cs.test;

import com.jsonyao.cs.entity.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectJConfig {

    @Pointcut("execution(* com.jsonyao.cs.controller.*.*(..))")
    private void pointcut() {

    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        System.err.println("around");
        long start = System.currentTimeMillis();

        Object[] args = point.getArgs();
        User user = User.class.cast(args[0]);
        user.setUsername(user.getUsername() + "测试AOP后缀");

        Object res = point.proceed(new Object[] {user});

        long end = System.currentTimeMillis();
        System.err.println("执行结果: " + res + ", 消耗时间: " + (end - start));
        return res;
    }
}
