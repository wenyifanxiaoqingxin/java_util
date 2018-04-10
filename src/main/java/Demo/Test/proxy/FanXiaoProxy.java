package Demo.Test.proxy;

import Demo.Test.Impl.FanXiao;
import Demo.Test.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by fx on 2017/12/7.
 */
public class FanXiaoProxy {

    private Person fx = new FanXiao();


    public Person getProxy(){

        return (Person) Proxy.newProxyInstance(FanXiaoProxy.class.getClassLoader(),
                fx.getClass().getInterfaces(), new InvocationHandler() {
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

//                    if(method.getName().equals("sing1")){
//                        System.out.println("代理成功，交过钱");
//                        return method.invoke(fx,args);
//
//                    }
//                    if(method.getName().equals("dance")){
//
//                        System.out.println("代理成功，交过钱");
//                        return  method.invoke(fx,args);
//                    }
                    System.out.println("代理成功，交过钱");
                        return  method.invoke(fx,args);
                }
        });

    }

}
