package leetcode.top100;

import java.util.*;

/**
 * @description: 对称二叉树
 * @author: fanxiao
 * @email: fanxiao@koolearn.com
 * @date: 2021/8/3 11:37 上午
 * 对称
 *    1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *不对称
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        return root==null?false: isSymmetric(root.left,root.right);
    }
    /**
     * @description:递归
     * @param:
     * @author: fanxiao,
     * @date: 2021/8/3 2:04 下午
     * @return: {@link boolean}
     */
    public boolean isSymmetric(TreeNode left,TreeNode right){

        if(left== null && right==null){
            return true;
        }
        if(left !=null && right!=null && left.val == right.val){
            return isSymmetric(left.left,right.right)?isSymmetric(left.right,right.left):false;
        }
        return false;
    }


     public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
          this.left = left;
          this.right = right;
      }
    }

    public boolean isSymmetricByQueue(TreeNode root) {
        if(root ==null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()){
            int sz = queue.size();
            TreeNode t1= queue.poll();
            TreeNode t2 = queue.poll();
            if(t1==null && t2==null){
                continue;
            }
            if(t1==null || t2==null ||t1.val!=t2.val){
                return false;
            }
            queue.offer(t1.left);
            queue.offer(t2.right);
            queue.offer(t1.right);
            queue.offer(t2.left);
        }
        return true;

    }

}
