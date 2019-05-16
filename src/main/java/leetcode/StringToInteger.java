package leetcode;

/**
 * @description:
 * @author: fanxiao
 * @date: 2019/4/24 19:00
 * 汉字：[0x4e00,0x9fa5]（或十进制[19968,40869]）
 * 数字：[0x30,0x39]（或十进制[48, 57]）
 * 小写字母：[0x61,0x7a]（或十进制[97, 122]）
 * 大写字母：[0x41,0x5a]（或十进制[65, 90]）
 * 其他：除上所有
 */
public class StringToInteger {
    public static void main(String[] args) {

        String str = "9223372036854775808";
        System.out.println("String to integer is:" + myAtoi(str));
    }

    public static int myAtoi(String str) {
        if (str == null && str.length() == 0) {
            return 0;
        }
        //是否为数字第一个不为空格的字符
        boolean isNumbers = false;
        //是否为负数
        boolean isNegative = false;
        long numbers = 0;
        for (int i = 0; i < str.length(); i++) {
            char word = str.charAt(i);
            int wordUnicode = (int) word;

            if (48 <= wordUnicode && wordUnicode <= 57) {
                isNumbers = true;
                if (isNegative) {
                    numbers = numbers * 10 - (wordUnicode - 48);
                    if (numbers <= Integer.MIN_VALUE) {
                        return Integer.MIN_VALUE;
                    }
                    continue;
                }
                numbers = numbers * 10 + ((wordUnicode - 48));
                if (numbers >= Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                continue;
            }
            if (isNumbers) {
                break;
            }
            if (word == '-') {
                isNumbers= true;
                isNegative = true;
                continue;
            }
            if (word == '+') {
                isNumbers= true;
                continue;
            }
            if (word != ' ') {
                break;
            }

        }
        return (int) numbers;
    }
}
