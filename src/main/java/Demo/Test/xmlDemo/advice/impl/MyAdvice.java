package Demo.Test.xmlDemo.advice.impl;

import Demo.Test.xmlDemo.advice.Advice;

import java.lang.reflect.Method;

/**
 * Created by fx on 2018/7/18.
 */
public class MyAdvice implements Advice{
    long beginTime = 0;

    public void beforeMethod(Method method) {
        System.out.println("aop执行之前的日志：");
        beginTime = System.currentTimeMillis();
    }

    public void afterMethod(Method method) {
        System.out.println("aop执行之后的日志：");
        long endTime =System.currentTimeMillis();
        System.out.println(method.getName()+"执行时间为："+(endTime-beginTime));
    }
}
