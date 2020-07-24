package datastructure.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Richard.Zhan
 * @Description: path sum
 * given a binary tree and a sum,determine if the tree has
 * a root-to-leaf path such that adding up all the values
 * along the path equals the given sum
 * @date 2020/7/23 18:16
 */
public class _0112_path_sum {


    /**
     * 递归解法
     *
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root,int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }

        return hasPathSum(root.left,sum - root.val)
                || hasPathSum(root.right,sum - root.val);
    }


    /**
     * BFS 解法
     * queue 先出列后入列
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSumBFS(TreeNode root,int sum) {

        if (root == null) {
            return false;
        }

        Queue<TreeNode> queueNode = new LinkedList<>();
        Queue<Integer> queueVal = new LinkedList<>();

        queueNode.offer(root);
        queueVal.offer(root.val);

        while (!queueNode.isEmpty()) {
            TreeNode curr = queueNode.poll();
            int temp = queueVal.poll();
            if (curr.left == null && curr.right == null) {
                if (temp == sum) {
                    return true;
                }
                continue;
            }
            if (curr.left != null) {
                queueNode.offer(curr.left);
                queueVal.offer(curr.left.val + temp);
            }
            if (curr.right != null) {
                queueNode.offer(curr.right);
                queueVal.offer(curr.right.val + temp);
            }
        }
        return false;

    }



    public static void main(String[] args) {
        System.out.println(false || true);


        _0112_path_sum instance = new _0112_path_sum();
        TreeNode root = new TreeNode(1);
        TreeNode rootLeft = new TreeNode(2);

        root.left = rootLeft;




        System.out.println(instance.hasPathSum(root,2));
        System.out.println(instance.hasPathSumBFS(root,3));


    }


}
