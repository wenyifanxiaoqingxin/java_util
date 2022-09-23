package leetcode.top100;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 无重复字符的最长子串 滑动窗口设计
 * @author: fanxiao
 * @email: fanxiao@koolearn.com
 * @date: 2021/7/30 4:16 下午
 */
public class NoRepeatString3 {

    public static int lengthOfLongestSubstring(String s) {
       Set<Character> set = new HashSet<>();
       int n = s.length();
       if(n <=1){
           return n;
       }
       int max = 1;
       int left =0,right = 0;
       while(right < n){
           char charStr = s.charAt(right);
           if(set.contains(charStr)){
                set.remove(left);
                left++;
           }
           max = Math.max(max,right-left +1);
           set.add(charStr);
           right++;
       }
       return  max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
