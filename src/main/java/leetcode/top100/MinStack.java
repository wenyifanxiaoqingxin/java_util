package leetcode.top100;

import java.util.LinkedList;

/**
 * @description: 最小栈
 * @author: fanxiao
 * @email: fanxiao@koolearn.com
 * @date: 2021/8/4 5:22 下午
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *
 *
 */
class MinStack {

    LinkedList<Integer> data;
    LinkedList<Integer> minData;
    /** initialize your data structure here. */
    public MinStack() {
        data = new LinkedList<Integer>();
        minData = new LinkedList<Integer>();
        minData.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        data.push(val);
        minData.push(Math.min(minData.peek(),val));
    }

    public void pop() {
        data.pop();
        minData.pop();
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return minData.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */