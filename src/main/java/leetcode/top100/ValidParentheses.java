package leetcode.top100;

import java.util.Stack;

/**
 * @description: 有效的括号
 * @author: fanxiao
 * @email: fanxiao@koolearn.com
 * @date: 2021/8/2 4:23 下午
 * 输入：s = "()"
 * 输出：true
 * 输入：s = "()[]{}"
 * 输出：true
 * 输入：s = "([)]"
 * 输出：false
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        char[] charArray = s.toCharArray();
        for(int i=0;i<charArray.length;i++){
            if(charArray[i] == '('){
                stack.push(')');
            }else if(charArray[i] == '['){
                stack.push(']');
            }else if(charArray[i] == '{'){
                stack.push('}');
            }else if(stack.isEmpty() || stack.pop()!=charArray[i]){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
