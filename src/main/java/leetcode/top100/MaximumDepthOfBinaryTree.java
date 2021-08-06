package leetcode.top100;

import leetcode.top100.data.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: some desc
 * @author: fanxiao
 * @email: fanxiao@koolearn.com
 * @date: 2021/8/3 3:15 下午
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 *    结果为3
 *
 */
public class MaximumDepthOfBinaryTree {

    /**
     * @description:递归
     * @param:
     * @author: fanxiao,
     * @date: 2021/8/3 3:18 下午
     * @return: {@link int}
     */
    public int maxDepth(TreeNode root) {

        if(root==null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;

    }
    /**
     * @description:队列
     * @param:
     * @author: fanxiao,
     * @date: 2021/8/3 3:22 下午
     * @return: {@link int}
     */
    public int maxDepthByQueue(TreeNode root) {

        if(root==null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            depth++;
            for(int i=0;i<size;i++){
                TreeNode treeNode = queue.poll();
                if(treeNode.left!=null){
                    queue.offer(treeNode.left);
                }
                if(treeNode.right!=null){
                    queue.offer(treeNode.right);
                }

            }

        }
        return depth;

    }


}
