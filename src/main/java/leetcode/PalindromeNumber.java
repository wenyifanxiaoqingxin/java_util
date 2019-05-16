package leetcode;

import java.util.Date;

/**
 * @description:
 * @author: fanxiao
 * @date: 2019/4/28 18:52
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        Long now =System.currentTimeMillis();
        System.out.println(isPalindrome(10));
        System.out.println("用时："+(System.currentTimeMillis()-now));
    }

    public static boolean isPalindrome(int x) {
        int ten = 10;
        if (x == 0) {
            return true;
        }
        if (x < 0 || (x % ten == 0)) {
            return false;
        }
        int palindromeNumber = 0;

        while (x > palindromeNumber) {
            palindromeNumber = palindromeNumber * ten + x % ten;
            x /= ten;

        }
        return palindromeNumber == x || x == palindromeNumber / ten;
    }
}
