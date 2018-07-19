package Demo.Test.aop.cglib;

/**
 * Created by fx on 2018/7/11.
 */
public class CglibTest {

    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();
        Base base = ProxyFactory.getInstance(cglibProxy);
        base.eat();
    }
}
