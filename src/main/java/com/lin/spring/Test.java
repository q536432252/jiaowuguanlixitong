package com.lin.spring;

import com.lin.service.SomeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.Jedis;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring/spring-test.xml");
        A beanA = ac.getBean(A.class);
        B beanB = ac.getBean(B.class);

        System.out.println(beanA.getB());
        System.out.println(beanB.getA());
      /* ApplicationContext ac = new ClassPathXmlApplicationContext("spring/spring-test.xml");
        SomeService someServiceImpl = (SomeService) ac.getBean("someServiceImpl");
        someServiceImpl.doSome(1,2);*/



        //redis 测试是否可以连通
        /*
        Jedis jedis = new Jedis("10.0.0.128",6379);
        System.out.println("redis服务器正在运行： " + jedis.ping());
         */



    }



}




