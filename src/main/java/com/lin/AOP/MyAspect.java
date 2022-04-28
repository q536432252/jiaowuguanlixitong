package com.lin.AOP;

import com.lin.pojo.UserLogin;
import com.lin.service.UserLoginService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

//@Aspect 是aspectj框架的注解， 表示当前类是切面类
@Aspect
@Component
public class MyAspect {

    @Before("execution(* com.lin.service.implTest.*.*(..))")
    public void myBefore() {
        //切面代码功能，如日志，事务处理
        System.out.println("前置通知");
    }

    @After("execution(* com.lin.service.implTest.*.*(..))")
    public void myAfter() {
        //切面代码功能，如日志，事务处理
        System.out.println("后后后通知");
    }


    //当用户登录的时候，显示登录者username  和 时间
    @After("execution(* com.lin.service.impl.UserLoginServiceImpl.selectByName(String))")
    public void doAfter(JoinPoint jp){
        /*
        Date visitTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //sdf.format(date)
        Object[] args = jp.getArgs();

        System.out.println("用户：" + args[0] + " 访问时间：" + sdf.format(visitTime));*/
    }
}
