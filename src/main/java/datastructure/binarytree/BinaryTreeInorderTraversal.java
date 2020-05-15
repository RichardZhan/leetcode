package datastructure.binarytree;

import java.util.ArrayList;

/**
 * @author Richard.Zhan
 * @Description: 中序遍历二叉树
 * @date 2020/5/14 11:19
 */
public class BinaryTreeInorderTraversal {

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




        return resultList;
    }


    public static void main(String[] args) {

    }


}
