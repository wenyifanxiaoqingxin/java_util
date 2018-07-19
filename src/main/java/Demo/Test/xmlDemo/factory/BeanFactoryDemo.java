package Demo.Test.xmlDemo.factory;

/**
 * Created by fx on 2018/7/18.
 */
//bean工厂
public interface BeanFactoryDemo {
    public <T> Object getBean(String id,Class<T> deffault) throws InterruptedException;
}
