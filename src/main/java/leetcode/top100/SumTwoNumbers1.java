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
public class SumTwoNumbers1 {

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
        Arrays.stream(twoSumUpgrade(nums, target)).forEach(System.out::println);
    }

    /**
     * @Author fanxiao3
     * @Description 优化后
     * @param nums
     * @param target
     * @Return int[]
     */
    public static int[] twoSumUpgrade(int[] nums, int target){

        Map<Integer,Integer> numsMap = new HashMap<>(nums.length);

        for(int i =0;i<nums.length;i++){
            Integer backup = target - nums[i];
            if(numsMap.containsKey(backup)){
                return new int[]{i,numsMap.get(backup)};
            }
            numsMap.put(nums[i],i);
        }
        return new int[]{};
    }


}
