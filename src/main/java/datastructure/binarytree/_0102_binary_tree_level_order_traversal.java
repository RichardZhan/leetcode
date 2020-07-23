package datastructure.binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author Richard.Zhan
 * @Description: 二叉树层序遍历
 * @date 2020/7/23 11:20
 */
public class _0102_binary_tree_level_order_traversal {


    /**
     * BFS 层序遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.add(root);
        }
        // while 循环的每一轮都是将当前层的所有节点出队列，再将下一层的多有节点入队列，实现层序遍历
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(level);
        }

        return res;
    }


    public static void main(String[] args) {
        List<List<Integer>> output = null;
        _0102_binary_tree_level_order_traversal instance = new _0102_binary_tree_level_order_traversal();
        TreeNode root = new TreeNode(1);
        TreeNode rootRight = new TreeNode(2);
        TreeNode rootRightRight = new TreeNode(3);

        root.right = rootRight;
        rootRight.right = rootRightRight;

        output = instance.levelOrder(root);
        System.out.println(output);

    }





}
