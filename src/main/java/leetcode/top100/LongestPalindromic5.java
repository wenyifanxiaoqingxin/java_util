package leetcode.top100;

/**
 * @description: 最长回文字符串
 * @author: fanxiao
 * @email: fanxiao@koolearn.com
 * @date: 2021/8/2 9:50 上午
 *输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 */
public class LongestPalindromic5 {

    public static String longestPalindrome(String s) {

        String res = "";
        if(s==null || s.length()<1){
            return res;
        }
        for(int i=0;i<s.length();i++){
            String leftStr = palindromeStr(s,i,i);
            String rightStr = palindromeStr(s,i,i+1);

            res = res.length()<leftStr.length()?leftStr:res;
            res = res.length()<rightStr.length()?rightStr:res;
        }
        return res;
    }

    private static String palindromeStr(String s,int left,int right){
        while (left>=0 && right<s.length()){

            if(s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }else{
                break;
            }
        }
        //因为substring为区间【left,right);前闭后开；所以left目前是减减之后不相等。
        return s.substring(left+1, right);
    }

    public static void main(String[] args) {
        String s= "babad";
        System.out.println(longestPalindrome(s));
    }
}
