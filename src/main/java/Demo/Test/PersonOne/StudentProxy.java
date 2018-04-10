package Demo.Test.PersonOne;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class StudentProxy {

    private Person person;

    private MonitoorUtil monitoorUtil = new MonitoorUtil();

    public StudentProxy(Person person){
        this.person = person;
    }

    public Person getProxys(){

        return (Person) Proxy.newProxyInstance(StudentProxy.class.getClassLoader(),
                person.getClass().getInterfaces(),new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        long startTime = System.currentTimeMillis();
                        Object ret = method.invoke(person,args);
                         monitoorUtil.invokeTime(startTime,System.currentTimeMillis());
                        return ret;
                    }
                });

    }



}
