package Demo.Test.xmlDemo;

import Demo.Test.xmlDemo.advice.Advice;
import Demo.Test.xmlDemo.factory.BeanFactoryDemo;
import Demo.Test.xmlDemo.factory.ProxyFactoryBean;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.springframework.cglib.proxy.Enhancer;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by fx on 2018/7/18.
 */
public class  ClassPathXmlLoader implements BeanFactoryDemo {
    private final Map<String,Object> beanMap = new HashMap<String,Object>();
    Properties props = new Properties();


    public ClassPathXmlLoader(InputStream ips) throws JDOMException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //读取配置文件
        props.load(ips);

        SAXBuilder saxBuilder = new SAXBuilder();
        System.out.println("开始读取配置文件--》");
        Document document = saxBuilder.build(this.getClass().getClassLoader().getResourceAsStream("bean.xml"));
        Element root = document.getRootElement();
        List list = root.getChildren("bean");
        for(int i=0;i<list.size();i++){

            Element element = (Element) list.get(i);
            String id = element.getAttributeValue("id");
            String clazz = element.getAttributeValue("class");

            Object o = Class.forName(clazz).newInstance();
            System.out.println(" bean id :"+id);
            System.out.println(" bean class : "+clazz);
            beanMap.put(id,o);

            for(Element propertyElement:(List<Element>)element.getChildren("property")){


                String name =propertyElement.getAttributeValue("name");
                String bean=propertyElement.getAttributeValue("bean");
                System.out.println("property name is "+name);
                System.out.println("property bean is "+bean);
                Object object = beanMap.get(bean);

                String methodName ="set" +name.substring(0,1).toUpperCase()+name.substring(1);
                System.out.println("根据name类名构造set方法"+methodName);
                System.out.println("开始反射执行set注入");
                Method method = o.getClass().getMethod(methodName,object.getClass().getInterfaces()[0]);
                method.invoke(o,object);
            }

        }
    }

    public  <T> T getBean(String id,Class<T> deffault) throws InterruptedException {
        T bean = (T)beanMap.get(id);
        // 如果目标被Spring管理了（这里以如果bean是ProxyFactoryBean类型的对象代替）则返回目标的代理对象，否则直接返回目标对象
        // 实际的Spring中，可以用spring的配置文件或者注解来判断是否被spring管理
        if (bean instanceof ProxyFactoryBean) {
            T proxy = null;
            ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
            try {
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(bean.getClass());
                enhancer.setCallback(proxyFactoryBean);
                proxy = (T)enhancer.create();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return proxy;
        }
        return bean;// 如果没有被spring管理，直接返回目标
//        return beanMap.get(id);
    }
}
