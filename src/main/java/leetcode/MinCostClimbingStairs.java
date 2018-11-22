package leetcode;

/**
 * Created by fx on 2018/9/20.
 */
public class MinCostClimbingStairs {

    public static int minCostClimbingStairs(int[] cost) {


        int f1 = cost[0]; int f2 = cost[1];
        for(int i =2;i<cost.length;i++){
            int last = cost[i]+Math.min(f1,f2);
            f1 = f2;
            f2 = last;

        }
        return Math.min(f1,f2);

    }
    public static void main(String[] args) {
        int[] prices = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs(prices));
    }
}
