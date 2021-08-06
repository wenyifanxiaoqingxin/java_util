package leetcode.top100.data;

import leetcode.top100.BinaryTreeInorderTraversal;

/**
 * @description: 树
 * @author: fanxiao
 * @email: fanxiao@koolearn.com
 * @date: 2021/8/3 3:16 下午
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 */
public class TreeNode {
    int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left,TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
