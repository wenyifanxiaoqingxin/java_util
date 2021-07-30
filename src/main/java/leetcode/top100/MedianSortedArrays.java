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
public class MedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n1 = nums1.length;
        int n2 = nums2.length;
        int left = (n1+n2+1)/2;
        int right = (n1+n2+2)/2;
        return (findKth(nums1,0,nums2,0,left)+findKth(nums1,0,nums2,0,right))/2.0;
    }

    public int findKth(int[] nums1,int i,int[] nums2,int j,int k){

        if(i>=nums1.length) return nums2[j+k-1];
        if(j>=nums2.length) return nums1[i+k-1];
        if(k==1){
            return Math.min(nums1[i],nums2[j]);
        }
        int mid1 = ((i+k/2-1<nums1.length))?nums1[i+k/2-1]:Integer.MAX_VALUE;
        int mid2 = ((j+k/2-1<nums2.length))?nums2[j+k/2-1]:Integer.MAX_VALUE;
        if(mid1<mid2){
            return findKth(nums1,i+k/2,nums2,j,k-k/2);
        }else{
            return findKth(nums1,i,nums2,j+k/2,k-k/2);
        }
    }

}
