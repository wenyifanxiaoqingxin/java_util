package leetcode;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by fx on 2018/8/24.
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if(s==null||s.length()<1){
            return "";
        }
        int end=0,start=0;
        for(int i=0;i<s.length();i++){
            int lengthOne = sumDistance(s,i,i);
            int lengthTwo =sumDistance(s,i,i+1);
            int len = Math.max(lengthOne,lengthTwo);
            if(len>end-start){
                start = i-(len-1)/2;
                end = i+len/2;
            }
        }

                return s.substring(start,end+1);
    }

    public int sumDistance(String s,int L,int R){
        int left = L,right=R;

        while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return  right-left-1;
    }


    public static void main(String[] args) {
        LongestPalindromicSubstring palindromicSubstring = new LongestPalindromicSubstring();
        System.out.println(palindromicSubstring.longestPalindrome("babad"));
    }
}
