package Demo.Test.aop.jdkProxy;

import org.apache.xpath.SourceTree;

/**
 * Created by fx on 2018/7/11.
 */
public class ServiceImpl implements Service{
    public void add() {
        System.out.println("serviceimpl 正在吃饭");
    }
}
