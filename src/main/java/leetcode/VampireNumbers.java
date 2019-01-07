package leetcode;


/**
 * Created by fx on 2018/12/26.
 * 编程思想 154页
 * 吸血鬼数字
 */
public class VampireNumbers extends Object{


    public static void main(String[] args) {
        for(int i=1000;i<9999;i++){
            int a= a(i);
            int b = b(i);
            int c = c(i);
            int d =d(i);
            if(b+c+d==b||b+c+d==c||b+c+d==d){
                continue;
            }
            vampireNumbers(i,combines(a,b),combines(c,d));
            vampireNumbers(i, combines(a, b), combines(d, c));
            vampireNumbers(i, combines(a, c), combines(b, d));
            vampireNumbers(i, combines(a, c), combines(d, b));
            vampireNumbers(i, combines(a, d), combines(b, c));
            vampireNumbers(i, combines(a, d), combines(c, b));
            vampireNumbers(i, combines(b, a), combines(c, d));
            vampireNumbers(i, combines(b, a), combines(d, c));
            vampireNumbers(i, combines(b, c), combines(d, a));
            vampireNumbers(i, combines(b, d), combines(c, a));
            vampireNumbers(i, combines(c, a), combines(d, b));
            vampireNumbers(i, combines(c, b), combines(d, a));
        }
    }

    public  static int a(int i){
        return i/1000;//千位数
    }
    public static int b(int i){

        return (i%1000)/100;//百位数
    }

    public static int c(int i){
        return ((i%1000)%100)/10;
    }

    public static  int d(int i){
        return i%10;
    }

    public static int combines(int a,int b){

        return (a*10)+b;
    }

    public static void vampireNumbers(int i,int m,int n){
        if(m*n==i){
            System.out.println(i+"="+m+"*"+n);
        }
    }
}
