package leetcode.top100;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author fanxiao3
 * @className ThreeSum15
 * @description 三数之和（双指针）
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0
 * @date 2022/9/29 5:01 下午
 */
public class ThreeSum15 {

    public  static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length < 3){
            return result;
        }
        Arrays.sort(nums);

        for(int i=0 ; i<nums.length ; i++){

            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i+1,right =nums.length-1;
            while(left < right ){
                int sum = nums[i] +nums[left]+nums[right];
                if(sum == 0){
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(nums[i]);
                    tempList.add(nums[left]);
                    tempList.add(nums[right]);
                    result.add(tempList);
                    while(left < right && nums[left] == nums[left+1]) {
                        left++;
                    }
                    while(left < right && nums[right] == nums[right-1]){
                        right --;
                    }
                    left++;
                    right--;
                }
                if(sum<0){
                    left ++ ;
                }
                if(sum>0){
                    right -- ;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        System.out.println(JSON.toJSONString(threeSum(nums)));
    }
}
