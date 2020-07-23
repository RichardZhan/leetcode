package datastructure.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Richard.Zhan
 * @Description: 中序遍历二叉树
 * @date 2020/5/14 11:19
 */
public class _0094_BinaryTreeInorderTraversal {

    public class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * @Description: 递归中序遍历二叉树
     * @Author: Richard
     * @Date: 2020/5/14 11:23
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root){
        ArrayList<Integer> resultList = new ArrayList<>();
        if (root == null){
            return resultList;
        }

        helper(root,resultList);

        return resultList;
    }

    public void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left,res);
            }
            res.add(root.val);
            if (root.right != null) {
                helper(root.right,res);
            }
        }
    }



    public static void main(String[] args) {
        _0094_BinaryTreeInorderTraversal instance = new _0094_BinaryTreeInorderTraversal();
        _0094_BinaryTreeInorderTraversal.TreeNode root = instance.new TreeNode(1);
        _0094_BinaryTreeInorderTraversal.TreeNode rootRight = instance.new TreeNode(2);
        _0094_BinaryTreeInorderTraversal.TreeNode rootRightLeft = instance.new TreeNode(3);
        root.right = rootRight;
        root.right.left = rootRightLeft;
        System.out.println(instance.inorderTraversal(root));



    }


}
