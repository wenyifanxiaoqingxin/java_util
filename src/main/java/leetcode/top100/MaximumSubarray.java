package leetcode.top100;

/**
 * @description: 最大子序和
 * @author: fanxiao
 * @email: fanxiao@koolearn.com
 * @date: 2021/8/2 5:48 下午
 *给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 *
 *
 */

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if(nums.length <2){
            return nums[0];
        }
        int sum = 0;
        int maxValue = nums[0];
        for(int i=0;i<nums.length;i++){
            sum = Math.max(sum+nums[i],nums[i]);
            maxValue = Math.max(maxValue,sum);
        }
        return maxValue;
    }
}
