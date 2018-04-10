package Demo.Test.Impl;

import Demo.Test.Person;

/**
 * Created by fx on 2017/12/7.
 */
public class FanXiao implements Person{


    public String sing(String name) {
        System.out.println("范晓唱"+name+"歌");
        return  "singing ended";
    }

    public String dance(String name) {
        System.out.println("范晓跳"+name+"舞蹈");
        return "dancing ended";
    }
}
