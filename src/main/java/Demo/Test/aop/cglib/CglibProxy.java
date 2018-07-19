package Demo.Test.aop.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by fx on 2018/7/11.
 */
public class CglibProxy implements MethodInterceptor{


    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("吃饭前先洗手");
        Object object = methodProxy.invokeSuper(o,objects);
        System.out.println("吃完饭后洗刷");
        return object;
    }
}
