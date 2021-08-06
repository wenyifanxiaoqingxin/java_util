package leetcode.top100;

/**
 * @description:  买卖股票的最佳时机
 * @author: fanxiao
 * @email: fanxiao@koolearn.com
 * @date: 2021/8/4 2:19 下午
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 *
 *
 */
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {

        if(prices==null || prices.length==0){
            return 0;
        }
        int minPrice = prices[0];
        int maxPrice = 0;
        for(int i=0;i<prices.length;i++){
            maxPrice = Math.max(maxPrice,prices[i]-minPrice);
            minPrice = Math.min(minPrice,prices[i]);
        }
        return maxPrice;
    }
}
