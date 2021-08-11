package leetcode.top100;

import leetcode.top100.data.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 103.二叉树的锯齿形层序遍历
 * @author: fanxiao
 * @email: fanxiao@koolearn.com
 * @date: 2021/8/10 3:10 下午
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *返回锯齿形层序遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 */
public class BinaryTreeZigZagLevelorderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {


        List<List<Integer>> result = new ArrayList();
        if(root == null){
            return result;
        }
        traversal(root,result,0);
        return result;
    }

    private void traversal(TreeNode root, List<List<Integer>> res, int level){

        if(root == null){
            return;
        }
        if(res.size() == level){
            res.add(new ArrayList<Integer>());
        }
        if((level%2) !=0){
            res.get(level).add(0,root.val);
        }else{
            res.get(level).add(root.val);
        }
        traversal(root.left,res,level+1);
        traversal(root.right,res,level+1);
    }
}
