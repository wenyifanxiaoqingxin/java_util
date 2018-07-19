package Demo.Test.xmlDemo;

/**
 * Created by fx on 2018/7/18.
 */
public class BMWcar implements Car{

    private String MyBrand ="宝马";

    public String getBrand() {
        return MyBrand;
    }

    public void run() {
        System.out.println(MyBrand+" is running!");
    }
}
