package datastructure.binarytree;

import java.util.HashMap;
import java.util.List;

/**
 * @author Richard.Zhan
 * @Description: construct binary tree from inorder and postorder traversal
 * given inorder and postorder traversal of a tree,construct the binary tree.
 * @date 2020/7/24 11:31
 */
public class _0106_construct_binary_tree_from_inorder_and_postorder_traversal {


    int post_idx;
    int[] postorder;
    int[] inorder;

    HashMap<Integer,Integer> idx_map = new HashMap<>();

    public TreeNode helper(int in_left,int in_right) {
        if (in_left > in_right) {
            return null;
        }
        // 后序遍历序列最后一位作为根节点
        int root_val = postorder[post_idx];
        TreeNode root = new TreeNode(root_val);

        // 中序遍历序列的值的下标
        int index = idx_map.get(root_val);

        post_idx --;
        root.right = helper(index + 1,in_right);
        root.left = helper(in_left,index - 1);
        return root;
    }

    public TreeNode buildTree(int[] inorder,int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;

        post_idx = postorder.length - 1;

        int idx = 0;
        for (int val : inorder) {
            idx_map.put(val,idx++);
        }
        return helper(0,inorder.length - 1);
    }


    public static void main(String[] args) {
        int[] inorder = new int[]{9,3,15,20,7};
        int[] postorder = new int[]{9,15,7,20,3};

        _0106_construct_binary_tree_from_inorder_and_postorder_traversal instance = new _0106_construct_binary_tree_from_inorder_and_postorder_traversal();
        TreeNode treeNode = instance.buildTree(inorder,postorder);


        _0094_BinaryTreeInorderTraversal pre = new _0094_BinaryTreeInorderTraversal();
        List<Integer> output = pre.inorderTraversal(treeNode);
        System.out.println(output);



    }


}
