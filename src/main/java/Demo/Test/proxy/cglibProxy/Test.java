package Demo.Test.proxy.cglibProxy;

/**
 * Created by fx on 2019/1/2.
 */
public class Test {

    public static void main(String[] args) {
        Student student = new Student("fx");
        Student student1 = (Student) new CglibProxyFactory(student).getTarget();
        student1.giveMoney();
    }
}
