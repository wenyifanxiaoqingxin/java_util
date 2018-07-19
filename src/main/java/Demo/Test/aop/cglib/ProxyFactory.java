package Demo.Test.aop.cglib;

import org.springframework.cglib.proxy.Enhancer;

/**
 * Created by fx on 2018/7/11.
 */
public class ProxyFactory {

    public static Base getInstance(CglibProxy cglibProxy){

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Base.class);
        enhancer.setCallback(cglibProxy);
        Base base = (Base) enhancer.create();
        return  base;
    }
}
