package leetcode.top100;

/**
 * @author fanxiao3
 * @className MaxArea11
 * @description 最大装水面积
 * @date 2022/9/28 4:13 下午
 */
public class MaxArea11 {

    public static int maxArea(int[] height) {
        int max = 0;
        if(height.length <= 1){
            return max;
        }
        int left =0,right = height.length-1;

        while(left < right){
            int heightNum = Math.min(height[right],height[left]);
            int longNum = right-left;
            int temp = heightNum * longNum;
            max = Math.max(temp,max);
            if(height[left] <= heightNum && left<right){
                left++;
            }
            if(height[right] <= heightNum && left < right){
                right--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

}
