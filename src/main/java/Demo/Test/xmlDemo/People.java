package Demo.Test.xmlDemo;

import Demo.Test.xmlDemo.factory.ProxyFactoryBean;
import org.apache.ibatis.executor.loader.ProxyFactory;

/**
 * Created by fx on 2018/7/18.
 */
public class People extends ProxyFactoryBean{
    //代理模式
    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void myCarRun(){
        System.out.println("起飞");
    }
}
