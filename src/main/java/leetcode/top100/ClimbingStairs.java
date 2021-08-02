package leetcode.top100;

/**
 * @description: 爬楼梯
 * @author: fanxiao
 * @email: fanxiao@koolearn.com
 * @date: 2021/8/2 6:16 下午
 *输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * 主要是d[n] = d[n-1]+d[n-2]
 *
 */
public class ClimbingStairs {

    public int climbStairs(int n) {

        if(n<2){
            return n;
        }
        int a =1;
        int b =2;
        for(int i=3;i<=n;i++){
            int sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}
