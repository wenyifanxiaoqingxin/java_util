package Demo.Test.aop.jdkProxy;

import java.lang.reflect.Proxy;

/**
 * Created by fx on 2018/7/11.
 */
public class JdkTest {

    public static void main(String[] args) {
        Service serviceImpl = new ServiceImpl();
        MyJdkProxyHandler myJdkProxyHandler = new MyJdkProxyHandler(serviceImpl);

        Service serviceProxy = (Service) Proxy.newProxyInstance(serviceImpl.getClass().getClassLoader(),serviceImpl.getClass().getInterfaces(),myJdkProxyHandler);
        serviceProxy.add();
    }
}
