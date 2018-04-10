package Demo.Test;

import Demo.Test.proxy.FanXiaoProxy;

/**
 * Created by fx on 2017/12/7.
 */
public class Protxytest {

    public static void main(String[] args){


        FanXiaoProxy fanXiaoProxy = new FanXiaoProxy();

        Person p = fanXiaoProxy.getProxy();
        String value = p.sing("我爱的人");
        System.out.println(value);

        String svalue = p.dance("gg");
        System.out.println(svalue);

    }
}
