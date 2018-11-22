package leetcode;

/**
 * Created by fx on 2018/11/19.
 */
public class HouseRobbeer {


    public int rob(int[] nums) {

        int now =0;
        int next = 0;
        int sum =0;
        if (nums.length < 1) {

            return 0;
        }else if(nums.length == 1){
            return nums[0];
        }else{
            next =  nums[0];
            for( int i=1;i<nums.length;i=i+2){

            }


        }


        return 0;
    }

    public static void main(String[] args) {

    }
}
