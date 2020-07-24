package datastructure.binarytree;

import java.util.HashMap;

/**
 * @author Richard.Zhan
 * @Description: construct binary tree from preorder and inorder traversal
 *
 * given preorder and inorder traversal of a tree,construct the binary tree.
 *
 * @date 2020/7/24 14:06
 */
public class _0105_construct_binary_tree_from_preorder_and_inorder_traversal {



    int pre_idx ;
    int[] preorder;
    int[] inorder;

    HashMap<Integer,Integer> inorder_map = new HashMap<>();



    public TreeNode buildTree(int[] preorder,int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;

        pre_idx = 0;
        int index = 0;
        for (int i : inorder) {
            inorder_map.put(i,index ++);
        }

        return helper(0,preorder.length -1);

    }

    private TreeNode helper(int in_left, int in_right) {
        if (in_left > in_right) {
            return null;
        }

        int val = preorder[pre_idx];
        TreeNode root = new TreeNode(val);

        int index = inorder_map.get(val);

        pre_idx ++;
        root.left = helper(in_left,index - 1);
        root.right = helper(index + 1,in_right);
        return root;


    }


    public static void main(String[] args) {
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};


        _0105_construct_binary_tree_from_preorder_and_inorder_traversal intance = new _0105_construct_binary_tree_from_preorder_and_inorder_traversal();

        TreeNode root = intance.buildTree(preorder,inorder);

        _0094_BinaryTreeInorderTraversal inorderTraversal = new _0094_BinaryTreeInorderTraversal();

        System.out.println(inorderTraversal.inorderTraversal(root));



    }




}
