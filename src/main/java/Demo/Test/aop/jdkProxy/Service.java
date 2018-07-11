package Demo.Test.aop.jdkProxy;

/**
 * Created by fx on 2018/7/11.
 */
public interface Service {
    //jdk动态代理必须实现统一的接口  硬性条件
    void add();
}
