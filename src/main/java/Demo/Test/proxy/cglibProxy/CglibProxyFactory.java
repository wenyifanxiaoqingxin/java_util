package Demo.Test.proxy.cglibProxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by fx on 2019/1/2.
 */
public class CglibProxyFactory implements MethodInterceptor{

    private Object target;
    public CglibProxyFactory(Object object){
        this.target = object;
    }

    //为目标对象创建代理对象


    public Object getTarget() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        enhancer.setClassLoader(target.getClass().getClassLoader());
        return enhancer.create();
    }

    @Override
    public Object intercept(Object object, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("开始代理");
        //执行目标方法
        Object o = method.invoke(target,objects);
        System.out.println("结束代理");
        return o;
    }
}
