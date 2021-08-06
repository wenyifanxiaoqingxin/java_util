package leetcode.top100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description: 二叉树的中序遍历
 * @author: fanxiao
 * @email: fanxiao@koolearn.com
 * @date: 2021/8/3 10:46 上午
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * 1
 *   2
 * 3
 */
public class BinaryTreeInorderTraversal {

    /**
     * @description:递归做法
     * @param:
     * @author: fanxiao,
     * @date: 2021/8/3 10:54 上午
     * @return: {@link List< Integer>}
     */
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> roots = new ArrayList<>();
        if(root==null){
            return roots;
        }
        if(root.left==null && root.right==null){
            roots.add(root.val);
            return roots;
        }
        if(root.left!=null){
            roots.addAll(inorderTraversal(root.left));
        }
        roots.add(root.val);
        if(root.right!=null){
            roots.addAll(inorderTraversal(root.right));
        }
        return roots;

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


    /**
     * @description:堆栈做法
     * @param:
     * @author: fanxiao,
     * @date: 2021/8/3 11:03 上午
     * @return: {@link List< Integer>}
     */
    public List<Integer> inorderTraversalByStack(TreeNode root) {
        List<Integer> list = new ArrayList();
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null || !stack.isEmpty()){
            if(root!=null){
                stack.push(root);
                root = root.left;
            }else{
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }
        return list;

    }




}
