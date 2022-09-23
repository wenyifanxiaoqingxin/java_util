package leetcode.top100;

import leetcode.top100.data.ListNode;

/**
 * @author fanxiao3
 * @className ListNodeReverse
 * @description TODO
 * @date 2022/8/22 3:15 下午
 */
public class ListNodeReverse {

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode current = head;
        while (current != null){
            ListNode temp = current.next;
            current.next = pre;
            pre = current;
            current= temp;
        }

        return pre;

    }
}
