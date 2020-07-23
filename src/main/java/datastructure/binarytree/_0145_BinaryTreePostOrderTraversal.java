package datastructure.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author Richard.Zhan
 * @Description: 后序遍历二叉树
 *
 * @date 2020/7/23 9:19
 */
public class _0145_BinaryTreePostOrderTraversal {


    /**
     * 递归遍历
     * @param root
     * @return
     */
    public ArrayList<Integer> postOrderTraversalRecursion(TreeNode root){
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null){
            return null;
        }

        helper(root,res);


        return res;
    }

    public void helper(TreeNode root, List<Integer> res) {
        if (root != null){
            if (root.left != null){
                helper(root.left,res);
            }
            if (root.right != null) {
                helper(root.right,res);
            }
            res.add(root.val);
        }
    }


    /**
     * 基于栈的遍历
     *
     * @param root
     * @return
     */
    public List<Integer> postOrderTraversalStack(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        if (root == null) {
            return res;
        }

        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pollLast();
            // 逆向输出
            res.addFirst(node.val);
            if (node.left != null){
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        _0145_BinaryTreePostOrderTraversal instance = new _0145_BinaryTreePostOrderTraversal();

        TreeNode root = new TreeNode(1);
        TreeNode rootRight = new TreeNode(2);
        TreeNode rootRightRight = new TreeNode(3);

        root.right = rootRight;
        rootRight.right = rootRightRight;


        System.out.println(instance.postOrderTraversalRecursion(root));

        System.out.println("-------------------------------------");

        System.out.println(instance.postOrderTraversalStack(root));


    }

}
