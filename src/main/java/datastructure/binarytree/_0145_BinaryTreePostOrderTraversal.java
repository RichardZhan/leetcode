package datastructure.binarytree;

import java.util.ArrayList;
import java.util.List;

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

    public static void main(String[] args) {
        _0145_BinaryTreePostOrderTraversal instance = new _0145_BinaryTreePostOrderTraversal();

        TreeNode root = new TreeNode(1);
        TreeNode rootRight = new TreeNode(2);
        TreeNode rootRightRight = new TreeNode(3);

        root.right = rootRight;
        rootRight.right = rootRightRight;


        System.out.println(instance.postOrderTraversalRecursion(root));



    }

}
