package Demo.Test.xmlDemo.factory;

import Demo.Test.xmlDemo.advice.Advice;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by fx on 2018/7/18.
 */
public class ProxyFactoryBean implements MethodInterceptor{
    private Advice advice;
    private Object object;

    //代理工厂执行代理对象
    public Object getProxy(){
        Object proxy = Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                advice.beforeMethod(method);//增强前置方法
                System.out.println("start");
                Object returnObject = method.invoke(object,args);//目标方法执行
                System.out.println("end");
                advice.afterMethod(method);//执行后置方法
                return returnObject;
            }
        });
        return proxy;
    }

    public Advice getAdvice() {
        return advice;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
//        advice.beforeMethod(method);//增强前置方法
        System.out.println("aop执行之前的日志：");
        long startTime =System.currentTimeMillis();
        Object objectProxy = methodProxy.invokeSuper(o,objects);
        System.out.println("aop执行之后的日志：");
        System.out.println("执行时间为："+(System.currentTimeMillis()-startTime)+"ms");
//        advice.afterMethod(method);//执行后置方法
        return objectProxy;
    }
}
