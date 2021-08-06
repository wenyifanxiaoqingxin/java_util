package leetcode.top100;

import leetcode.top100.data.ListNode;

import java.util.Stack;

/**
 * @description: 环形链表
 * @author: fanxiao
 * @email: fanxiao@koolearn.com
 * @date: 2021/8/4 3:25 下午
 * 3->2->0->4
 *   |______|
 *输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 利用快慢指针，让快的先跑，慢的就在后面慢慢走，总会有一次慢的超过快的或者快的又再次超过慢的
 *
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {

        ListNode fast= head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow  = slow.next;
            if(fast == slow){
                return true;
            }

        }
        return false;
    }


}
