package leetcode;

import leetcode.top100.data.TreeNode;

/**
 * @description: 236. 二叉树的最近公共祖先
 * @author: fanxiao
 * @email: fanxiao@koolearn.com
 * @date: 2021/8/10 2:42 下午
 *       3
 *     5   1
 *   6  2 0 8
 *     7 4
 * root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 *
 */
public class LowestCommonAncestorOfBinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        if(root== p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left!= null && right != null){
            return root;
        }else if(left!= null){
            return left;
        }else if(right !=null){
            return right;
        }
        return null;
    }


}
