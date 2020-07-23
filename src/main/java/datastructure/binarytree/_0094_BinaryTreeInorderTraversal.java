package datastructure.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Richard.Zhan
 * @Description: 中序遍历二叉树
 * @date 2020/5/14 11:19
 */
public class _0094_BinaryTreeInorderTraversal {


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

    // --------------------------------------------------------

    /**
     * 基于栈的遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalStack(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;
        // 先进后出原则，关注栈内元素
        while (curr != null || !stack.isEmpty()){
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }

        return res;

    }



    public static void main(String[] args) {
        _0094_BinaryTreeInorderTraversal instance = new _0094_BinaryTreeInorderTraversal();
        TreeNode root = new TreeNode(1);
        TreeNode rootRight = new TreeNode(2);
        TreeNode rootRightLeft = new TreeNode(3);
        root.right = rootRight;
        root.right.left = rootRightLeft;
        System.out.println(instance.inorderTraversal(root));


        // ----------------------------------------------------------------------
        System.out.println(instance.inorderTraversalStack(root));


    }


}
