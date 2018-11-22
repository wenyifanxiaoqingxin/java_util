package leetcode;

/**
 * Created by fx on 2018/9/20.
 */
public class MaxProfit {

    public static int maxProfit(int[] prices){

        int minPricee = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i =0;i<prices.length;i++){


            if(prices[i]<minPricee){
                minPricee = prices[i];
            }else if(prices[i]-minPricee>maxProfit){
                maxProfit = prices[i]-minPricee;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
