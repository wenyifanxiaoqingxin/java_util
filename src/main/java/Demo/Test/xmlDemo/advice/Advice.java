package Demo.Test.xmlDemo.advice;

import java.lang.reflect.Method;

/**
 * Created by fx on 2018/7/18.
 */
public interface Advice {
    void beforeMethod(Method method);
    void afterMethod(Method method);
}
