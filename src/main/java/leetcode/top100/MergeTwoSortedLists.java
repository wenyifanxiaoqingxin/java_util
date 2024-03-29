package leetcode.top100;

/**
 * @description: 合并两个有序链表
 * @author: fanxiao
 * @email: fanxiao@koolearn.com
 * @date: 2021/8/2 5:03 下午
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 ==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode dummyHead = new ListNode(0);
        ListNode list = dummyHead;
        while(l1!=null){
            if(l2==null || l1.val<=l2.val){
                list.next = l1;
                list = list.next;
                l1=l1.next;
            }else{
                list.next = l2;
                list = list.next;
                l2=l2.next;
            }
        }
        if(l2!=null){
            list.next = l2;
            list = list.next;
            l2=l2.next;
        }
        return dummyHead.next;
    }


    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static void main(String[] args) {
        System.out.println();
    }
}
