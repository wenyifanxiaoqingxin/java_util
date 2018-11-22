package Demo.Test.aop.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by fx on 2018/7/11.
 */
public class CglibProxy implements MethodInterceptor{

    private Object object;//业务类对象，供代理方法中进行真正的业务方法调用

    public Object getInstance(Object target){
        this.object = target;
        Enhancer enhancer = new Enhancer();//创建加强器，用来创建动态代理类
        enhancer.setSuperclass(this.object.getClass());//为加强器指定要代理的业务类（即：为下面生成的代理类指定父类）

        //设置回调：对于代理类上所有方法的调用，都会调用CallBack，而Callback则需要实现intercept()方法进行拦
        enhancer.setCallback(this);
        return enhancer.create();
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("吃饭前先洗手");
        Object object = methodProxy.invokeSuper(o,objects);
        System.out.println("吃完饭后洗刷");
        return object;
    }
}
