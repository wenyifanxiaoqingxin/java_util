package leetcode.top100;

import leetcode.top100.data.ListNode;

/**
 * @description: 链表相加之和
 * @author: fanxiao
 * @email: fanxiao@koolearn.com
 * @date: 2021/7/30 2:26 下午
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 *
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *
 */
public class TwoLinkSums2 {

    /**
     * @description: 主要考虑进位这个数字怎么计算
     * @param:
     * @author: fanxiao,
     * @date: 2021/7/30 3:58 下午
     * @return: {@link null}
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result =new ListNode(0);
        if(l1 == null && l2 == null ){
            return result;
        }
        int carry = 0 ;
        ListNode dump = result;
        while(l1 != null || l2 != null || carry >0){
            int l1Value = 0;
            int l2Value = 0;
            if(l1 != null){
                l1Value = l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                l2Value = l2.val;
                l2 = l2.next;
            }
            int sum = l1Value + l2Value + carry ;
            carry = sum / 10;
            dump.next = new ListNode( sum % 10);
            dump = dump.next;
        }
        return result.next;
    }

    public static void main(String[] args) {

    }

}
