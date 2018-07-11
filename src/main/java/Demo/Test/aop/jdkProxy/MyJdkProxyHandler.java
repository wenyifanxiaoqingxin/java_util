package Demo.Test.aop.jdkProxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by fx on 2018/7/11.
 */
public class MyJdkProxyHandler implements InvocationHandler{

    private Object object;

    MyJdkProxyHandler(){
        super();
    }
    MyJdkProxyHandler(Object o){
        super();
        this.object = o;
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("吃之前先洗手");
        Object result = method.invoke(object,args);
        System.out.println("吃完收拾碗筷");
        return result;
    }
}
