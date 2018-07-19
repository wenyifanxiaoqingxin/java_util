package Demo.Test.xmlRead;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import java.io.IOException;
import java.util.List;

/**
 * Created by fx on 2018/7/18.
 */
public class JdomSample {
    public static void main(String[] args) throws JDOMException, IOException {
        SAXBuilder sb = new SAXBuilder();
        Document document =sb.build(JdomSample.class.getClassLoader().getResourceAsStream("demo.xml"));//文档对象
        Element root = document.getRootElement();//根元素WORLD
        List list = root.getChildren("country");//获取国家
        for(int i =0;i<list.size();i++){

            Element element = (Element) list.get(i);
            String name = element.getAttributeValue("name");
            String city = element.getChildText("city");
            String province = element.getChildText("province");
            String area = element.getChildText("area");
            String people = element.getChildText("people");


            System.out.println("世界信息：");
            System.out.println("国家："+name);

            System.out.println("城市："+city);

            System.out.println("所在省份："+province);

            System.out.println("所占面积："+area);
            System.out.println("人口总量："+people);
            System.out.println("-----------------------------------");
        }

    }
}
