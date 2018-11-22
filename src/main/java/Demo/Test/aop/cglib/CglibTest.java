package Demo.Test.aop.cglib;

/**
 * Created by fx on 2018/7/11.
 */
public class CglibTest {

    public static void main(String[] args) {
        Base base = new Base();
        CglibProxy cglibProxy = new CglibProxy();
        Base baseCglib = (Base) cglibProxy.getInstance(base);
        baseCglib.eat();
    }
}
