package Demo.Test.xmlDemo;

import org.jdom.JDOMException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by fx on 2018/7/18.
 */
public class MainTest {

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, IOException, InstantiationException, JDOMException, NoSuchMethodException, ClassNotFoundException, InterruptedException {
        InputStream ips = MainTest.class.getClassLoader().getResourceAsStream("config.properties");
        ClassPathXmlLoader classPathXmlLoader = new ClassPathXmlLoader(ips);
        People people =  classPathXmlLoader.getBean("people",People.class);
        System.out.println("注入完成，开始执行方法");
        people.myCarRun();
//        'ui1524210935151372950',NULL,'863125035167189','shipengfei@cri.cn','1c144d77662d4d1e6aa05685a8d85c95',NULL,NULL,NULL,NULL,NULL,'7','2018-04-20 16:01:58','2018-04-20 16:01:58','2018-04-20 16:01:58','124.65.46.34',NULL,NULL,'uvc1524211275820421357','Android 7.0','3.0','3',NULL,NULL
//        'ui1525841545923989622',NULL,'271BDEC3-A580-45AA-9D16-B66A54CD3884','shipengfei@cri.cn','ef99c9960b17aba9408822bfb76276eb','989622','http://impamp.crionline.cn:8081/M00/1A/03/ZSUfPFrygkuAXFerAAC_0b6xx0c948.jpg',NULL,'0',NULL,'2','2018-05-09 12:56:54','2018-05-09 12:56:54','2018-05-09 14:07:11','124.65.46.34',NULL,NULL,'uvc1525841910842729628',NULL,'3.5.6','3',NULL,NULL
//        'ui1528871583308120575',NULL,'10593','shipengfei@cri.cn','0870a3b5922ebb2b280854d861775a5c',NULL,NULL,NULL,NULL,NULL,'11','2018-06-13 14:33:50',NULL,NULL,NULL,NULL,NULL,'uvc1528871583302781297','1','1.3','3',NULL,NULL

    }
}
