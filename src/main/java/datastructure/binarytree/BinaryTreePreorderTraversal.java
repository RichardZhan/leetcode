package datastructure.binarytree;


import java.util.ArrayList;
import java.util.Stack;

/**
 * @Description: 二叉树 前序遍历
 * @Author: Richard
 * @Date: 2020/5/9 22:54
 */
public class BinaryTreePreorderTraversal {


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
        stack.push(flagNode);
        while (!stack.isEmpty()){
            TreeNode currentNode = stack.pop();
            if (currentNode.right != null){
                TreeNode tempNode = currentNode.right;
                while (tempNode != null){
                    stack.push(tempNode);
                    resultList.add(tempNode.val);
                    tempNode = tempNode.left;
                }
            }
        }

        return resultList;
    }


    public static void main(String[] args) {
        BinaryTreePreorderTraversal instance = new BinaryTreePreorderTraversal();
        TreeNode root = instance.new TreeNode(1);
        TreeNode rootRight = instance.new TreeNode(2);
        TreeNode rootRightLeft = instance.new TreeNode(3);
        root.right = rootRight;
        root.right.left = rootRightLeft;
        System.out.println(instance.preorderTraversal(root));
    }

}