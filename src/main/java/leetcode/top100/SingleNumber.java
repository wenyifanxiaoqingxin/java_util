package leetcode.top100;

/**
 * @description: 只出现一次的数字
 * @author: fanxiao
 * @email: fanxiao@koolearn.com
 * @date: 2021/8/4 2:36 下午
 * 输入: [2,2,1]
 * 输出: 1
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class SingleNumber {

    /**
     * @description:关键解法在于异或，自己和自己异或或者自己和0异或都为0；
     * @param:
     * @author: fanxiao,
     * @date: 2021/8/4 2:36 下午
     * @return: {@link int}
     */
    public int singleNumber(int[] nums) {

        int number =0;
        for(int i=0;i<nums.length;i++){
            number=number^nums[i];
        }
        return number;
    }
}
