package Demo.Test.PersonOne;

import java.util.ArrayList;
import java.util.Collections;

public class test {

    public static  void  main(String[] args){

        Person person = new Student("小明");
        StudentProxy studentProxy = new StudentProxy(person);
        person  =  studentProxy.getProxys();
        person.giveMoney();

        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");
        arrayList.add("E");
        System.out.println("反转前排序: " + arrayList);
        Collections.reverse(arrayList);
        Collections.max(arrayList);
        Collections.sort(arrayList);
        System.out.println("反转后排序: " + arrayList);
    }
}
