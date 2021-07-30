package leetcode.top100;

/**
 * @description: 链表想加之和
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
public class TwoLinkSums {

    /**
     * @description: 主要考虑进位这个数字怎么计算
     * @param:
     * @author: fanxiao,
     * @date: 2021/7/30 3:58 下午
     * @return: {@link null}
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNodeResult = new ListNode(0);
        ListNode cursor = listNodeResult;
        if(l1==null && l2== null ){
            return cursor;
        }
        int t =0;
        while (l1!=null || l2!=null || t!=0 ){
            if(l1!=null){
                t+=l1.val;
                l1= l1.next;
            }
            if(l2!=null){
                t+=l2.val;
                l2= l2.next;
            }
            ListNode l3 = new ListNode(t%10);
            cursor.next =l3;
            t= t/10;
            cursor = l3;
        }
        return listNodeResult.next;

    }

     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

}
