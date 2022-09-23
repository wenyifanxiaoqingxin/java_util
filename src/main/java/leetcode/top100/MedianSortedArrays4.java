package leetcode.top100;

/**
 * @description: 寻找两个有序数组的中位数
 * @author: fanxiao
 * @email: fanxiao@koolearn.com
 * @date: 2021/7/30 6:06 下午
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 *
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 */
public class MedianSortedArrays4 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1= nums1.length;
        int n2 = nums2.length;

        int left = (n1+n2+1)/2;
        int right = (n1+n2+2)/2;
        //开始二分查找两个数组
        return (findMedian(nums1,0,nums2,0,left)+findMedian(nums1,0,nums2,0,right))/2.0;
    }


    private static int findMedian(int[] nums1,int left, int[] nums2 ,int right ,int temp){
        if(left >= nums1.length){
            return nums2[right+temp-1];
        }
        if(right >= nums2.length){
            return nums1[left+temp-1];
        }
        if(temp == 1){
            return Math.min(nums1[left], nums2[right]);
        }
        int midValue1 = (left+temp/2-1< nums1.length) ? nums1[left+temp/2-1]:Integer.MAX_VALUE;
        int midValue2 = (right+temp/2-1) < nums2.length ? nums2[right+temp/2 -1] : Integer.MAX_VALUE;
        if(midValue1 < midValue2){
            return findMedian(nums1,left+temp/2,nums2,right,temp-temp/2);
        }
        return findMedian(nums1,left,nums2,right+temp/2,temp-temp/2);
    }

    public static void main(String[] args) {
        int[] nums1 =new int[]{1,2};
        int[] nums2 =new int[]{3,4};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }

}
