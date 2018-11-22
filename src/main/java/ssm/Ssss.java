package ssm;

/**
 * Created by fx on 2018/8/31.
 */
public class Ssss {

    public static void main(String[] args) {
        String s = "贵州<font color='red'>好</font>水组团赴泸角逐中国<font color='red'>好</font>水";
        s=s.replaceAll("color='red'","color='blue'");
        System.out.println(s);
    }
}
