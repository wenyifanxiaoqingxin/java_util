package leetcode.top100;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 无重复字符的最长子串
 * @author: fanxiao
 * @email: fanxiao@koolearn.com
 * @date: 2021/7/30 4:16 下午
 */
public class NoRepeatString {

    public static int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int l = s.length();
        int max =0;
        int temp =0;
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                temp = Math.max(temp,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-temp+1);

        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }
}
