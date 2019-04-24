package leetcode;

/**
 * @description:
 * @author: fanxiao
 * @date: 2019/4/23 19:15
 */
public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(-123));
    }
    public static int reverse(int x){
        //防止溢出报错  直接定义long类型
        long afterReverse = 0;
        while (x!=0){
            int result = x%10;
            x/=10;
            afterReverse = afterReverse*10+ result;
        }
        if(afterReverse>Integer.MAX_VALUE||afterReverse<Integer.MIN_VALUE)
            return 0;
        return  (int) afterReverse;

    }
}
