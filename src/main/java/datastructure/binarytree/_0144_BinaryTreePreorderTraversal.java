package datastructure.binarytree;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description: 二叉树 前序遍历
 * @Author: Richard
 * @Date: 2020/5/9 22:54
 */
public class _0144_BinaryTreePreorderTraversal {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }


    /**
     * @Description: 内存消耗 时间复杂度
     * stack LIFO
     * @Author: Richard
     * @Date: 2020/5/14 10:53
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> resultList = new ArrayList<>();
        if (root == null){
            return resultList;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode flagNode = new TreeNode(0);
        flagNode.right = root;
        // stack push
        stack.push(flagNode);

        while (!stack.isEmpty()){
            TreeNode currentNode = stack.pop();
            if (currentNode.right != null){
                TreeNode tempNode = currentNode.right;
                while (tempNode != null){
                    // 为原路返回
                    stack.push(tempNode);
                    resultList.add(tempNode.val);
                    tempNode = tempNode.left;
                }
            }
        }
        return resultList;
    }


    /**
     * 递归前序遍历
     * @param root
     * @return
     */
    public ArrayList<Integer> preorderTraversalRecursion(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return null;
        }
        helper(root,res);

        return res;
    }

    public void helper(TreeNode root, List<Integer> res){
        if (root != null) {
            res.add(root.val);
            if (root.left != null){
                helper(root.left,res);
            }
            if (root.right != null){
                helper(root.right,res);
            }
        }
    }


    public static void main(String[] args) {
        _0144_BinaryTreePreorderTraversal instance = new _0144_BinaryTreePreorderTraversal();
        TreeNode root = instance.new TreeNode(1);
        TreeNode rootRight = instance.new TreeNode(2);
        TreeNode rootRightLeft = instance.new TreeNode(3);
        root.right = rootRight;
        root.right.left = rootRightLeft;
        System.out.println(instance.preorderTraversal(root));

        //-----------------------------------------------------------------


        // 递归遍历
        System.out.println(instance.preorderTraversalRecursion(root));

    }

}
