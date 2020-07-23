package datastructure.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Richard.Zhan
 * @Description: symmetric tree
 * given a binary tree,check whether it is a mirror
 * of itself (ie,symmetric around its center)
 * @date 2020/7/23 17:49
 */
public class _0101_symmetric_tree {


    /**
     * 递归判断是否对称
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return check(root,root);
    }

    public boolean check(TreeNode p,TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }

        return p.val == q.val
                && check(p.left,q.right)
                && check(p.right,q.left);
    }


    /**
     * BFS
     * @param root
     * @return
     */
    public boolean isMarrir(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();

            if (t1 == null && t2 == null) {
                continue;
            }
            if (t1 == null || t2 == null ) {
                return false;
            }
            if (t1.val != t2.val) {
                return false;
            }

            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }


        return true;
    }




    public static void main(String[] args) {

        _0101_symmetric_tree instance = new _0101_symmetric_tree();

        TreeNode root = new TreeNode(1);
        TreeNode rootRight = new TreeNode(2);
        TreeNode rootRightLeft = new TreeNode(3);
        root.right = rootRight;
        root.right.left = rootRightLeft;


        System.out.println(instance.isSymmetric(root));

        System.out.println(instance.isMarrir(root));
    }




}
