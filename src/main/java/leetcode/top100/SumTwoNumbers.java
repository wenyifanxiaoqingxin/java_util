package leetcode.top100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 两数只和
 * @author: fanxiao
 * @email: fanxiao@koolearn.com
 * @date: 2021/7/28 5:40 下午
 */
public class SumTwoNumbers {

    public static int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }

        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,4};
        int target = 6;
        Arrays.stream(twoSum(nums, target)).forEach(System.out::println);
    }

    /**
     * @description:优化后
     * @param:
     * @author: fanxiao,
     * @date: 2021/7/28 6:10 下午
     * @return: {@link int[]}
     */
    public static int[] twoSumMax(int[] nums, int target) {

        int[] re = new int[2];
        if(nums==null || nums.length == 0){
            return re;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int temp = target-nums[i];
            if(map.containsKey(temp)){
                re[0] = map.get(temp);
                re[1] = i;
                return re;
            }
            map.put(nums[i],i);
        }
        return re;
    }


}
